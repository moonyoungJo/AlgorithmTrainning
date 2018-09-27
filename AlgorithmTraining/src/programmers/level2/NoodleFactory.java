package programmers.level2;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 라면공장
 * 
 * 라면 공장에서는 하루에 밀가루를 1톤씩 사용합니다. 
 * 원래 밀가루를 공급받던 공장의 고장으로 앞으로 k일 이후에야 밀가루를 공급받을 수 있기 때문에
 *  해외 공장에서 밀가루를 수입해야 합니다.
 *  해외 공장에서는 향후 밀가루를 공급할 수 있는 날짜와 수량을 알려주었고, 
 *  라면 공장에서는 운송비를 줄이기 위해 최소한의 횟수로 밀가루를 공급받고 싶습니다.
 *  
 *  현재 공장에 남아있는 밀가루 수량 stock, 
 *  밀가루 공급 일정(dates)과 해당 시점에 공급 가능한 밀가루 수량(supplies), 
 *  원래 공장으로부터 공급받을 수 있는 시점 k가 주어질 때, 
 *  밀가루가 떨어지지 않고 공장을 운영하기 위해서 
 *  최소한 몇 번 해외 공장으로부터 밀가루를 공급받아야 하는지를 return 하도록 solution 함수를 완성하세요.
 *  
 *  dates[i]에는 i번째 공급 가능일이 들어있으며, 
 *  amounts[i]에는 dates[i] 날짜에 공급 가능한 밀가루 수량이 들어 있습니다.
 */
public class NoodleFactory {
	public static void main(String[] args) {
		int stock = 7;
		int[] dates = {4, 10, 15};
		int[] supplies = {20, 5, 10};
		int k = 30;
		System.out.println(new NoodleFactory().solution(stock, dates, supplies, k));
	}
	public int solution(int stock, int[] dates, int[] supplies, int k) {
        
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg1 - arg0;
			}
		});

		int answer = 0;
		int day = stock;
		int index = 0;
		while(day < k) {
			while(index < dates.length && dates[index] <= day) {
				queue.add(supplies[index]);
				index++;
			}
			answer++;
			day += queue.poll();
		}
		
        return answer;
    }
}