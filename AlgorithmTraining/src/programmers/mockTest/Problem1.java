package programmers.mockTest;

/*
 * 앞에서부터 읽을 때와 뒤에서부터 읽을 때 똑같은 단어를 팰린드롬(palindrome)이라고 합니다.
 * 예를들어서 racecar, 10201은 팰린드롬 입니다.
 * 두 자연수 n, m이 매개변수로 주어질 때, n 이상 m 이하의 자연수 중 팰린드롬인 
 * 숫자의 개수를 return 하도록 solution 함수를 완성해 주세요.
 */
public class Problem1 {
	
	public int solution(int n, int m) {
		int answer = 0;

		for (int i = n; i <= m; i++) {
			//10이하는 무조건 팰린드롭
			if (i < 10) {
				answer++;
				continue;
			}

			int inv = i % 10;
			//맨 뒤의 수가 0이면 팰린드롭이 무조건 안됨
			if (inv == 0)
				continue;
			int seq = i / 10;
			int tmp;
			
			//숫자를 절반으로 쪼갬 
			while (seq / inv >= 100) {
				inv = inv * 10 + seq % 10;
				seq = seq / 10;
			}
			
			//자리수가 홀수이면 가운데 자리는 고려하지 않아도 된다.
			if (seq / inv >= 10) {
				seq = seq / 10;
			}
			//비교
			if (seq == inv) {
				answer++;
			}
		}

		return answer;
	}
}
