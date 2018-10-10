package programmers.level2;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 가장 큰 수
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면
 *  [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 *  
 *  0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 
 *  순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *  
 *  제한 사항
 *  numbers의 길이는 1 이상 100,000 이하입니다.
 *  numbers의 원소는 0 이상 1,000 이하입니다.
 *  정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 *  
 *  풀이 : 두 수를 합쳐서 비교해본다!
 */
public class MaxNum {
	public static void main(String[] args) {
		int[] numbers = {0, 0, 0, 0};
		System.out.println(new MaxNum().solution(numbers));
	}
	public String solution(int[] numbers) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				String[] s = {arg0.toString(), arg1.toString()};
				int[] concat = {Integer.parseInt(s[0] + s[1]), Integer.parseInt(s[1] + s[0])};
				
				return concat[1] - concat[0];
			}
				
		});
		
		for(int n : numbers) {
			queue.add(n);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			sb.append(queue.poll());
		}

		if(sb.charAt(0) == '0')
			return "0";
        
        return sb.toString();
    }
}