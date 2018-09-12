package programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * n명의 사람이 일렬로 줄을 서고 있습니다. 
 * n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다. 
 * n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다. 
 * 예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.
 * 
 * [1, 2, 3]
 * [1, 3, 2]
 * [2, 1, 3]
 * [2, 3, 1]
 * [3, 1, 2]
 * [3, 2, 1]
 * 사람의 수 n과, 자연수 k가 주어질 때, 
 * 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, 
 * 
 * k번째 방법을 return하는 solution 함수를 완성해주세요.
 * 
 * 효율성을 높이도록 다시 짜야 함
 */
public class Queueing {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Queueing().solution(4, 6)));
	}

	public int[] solution(int n, long k) {
		int[] answer = new int[n];
		List<Integer> notUsed = new LinkedList<>();
		notUsed.add(1);
		int fac = 1;
		
		for (int i = 2; i <= n; i++) {
			notUsed.add(i);
			fac *= i;
		}

		k--;
		for (int index = 0; index < answer.length; index++) {
			fac = fac / (n - index);
			int num = (int) (k / fac);
			k = k % fac;

			answer[index] = notUsed.get(num);
			notUsed.remove(num);
		}

		return answer;
	}
}
