package programmers.level2;

import java.util.Arrays;

/*
 * 주식가격
 * 
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
 * 가격이 유지된 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 * 
 * 입력 : [498,501,470,489]
 * 출력 : [2,1,1,0]
 */
public class StockPrice {
	public static void main(String[] args) {
		int[] prices = {4, 3, 2, 1};
		System.out.println(Arrays.toString(new StockPrice().solution(prices))	);
	}

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		

		for(int target = 0; target < prices.length-1; target++) {
			boolean valid = true;
			
			for(int pointer = target+1; pointer < prices.length; pointer++) {
				if(!valid)
					break;
				
				if(prices[target] > prices[pointer]) {
					valid = false;
				}
				answer[target]++;
			}
		}

		return answer;
	}
}
