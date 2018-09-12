package programmers.level3;

import java.util.Arrays;

/*
 * 자연수 n 개로 이루어진 집합 중에 다음 두 조건을 만족하는
 * 집합을 최고의 집합이라고 합니다.
 * 1. 각 원소의 합이 S가 되는 수의 집합
 * 2. 위 조건을 만족하면서 각 원소의 곱 이 최대가 되는 집합
 * 
 * 예를 들어서 자연수 2개로 이루어진 집합 중 합이 9가 되는 집합은 다음과 같이 4개가 있습니다.
 * { 1, 8 }, { 2, 7 }, { 3, 6 }, { 4, 5 }
 * 
 * 그중 각 원소의 곱이 최대인 { 4, 5 }가 최고의 집합입니다.
 * 집합의 원소의 개수 n과 모든 원소들의 합 s가 매개변수로 주어질 때, 
 * 최고의 집합을 return 하는 solution 함수를 완성해주세요.
 */
public class BestSet {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new BestSet().solution(2, 9)));
	}
	public int[] solution(int n, int s) {
		if(s < n)
			return new int[] {-1};
		
		int[] answer = new int[n];
		int share = s/n;
		int rest = s%n;
		
		for(int i = 0; i < n-rest; i++) {
			answer[i] = share;
		}
		for(int i = n-rest; i < n; i++) {
			answer[i] = share + 1;
		}
		
		return answer;
	}
}
