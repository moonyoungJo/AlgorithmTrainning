package programmers.level3;

/*
 * Finn은 편의점에서 야간 아르바이트를 하고 있습니다. 
 * 야간에 손님이 너무 없어 심심한 Finn은 손님들께 거스름돈을 
 * n 원을 줄 때 방법의 경우의 수를 구하기로 하였습니다.
 * 
 * 예를 들어서 손님께 5원을 거슬러 줘야 하고 1원, 2원, 5원이 있다면 
 * 다음과 같이 4가지 방법으로 5원을 거슬러 줄 수 있습니다.
 * 
 * 1원을 5개 사용해서 거슬러 준다.
 * 1원을 3개 사용하고, 2원을 1개 사용해서 거슬러 준다.
 * 1원을 1개 사용하고, 2원을 2개 사용해서 거슬러 준다.
 * 5원을 1개 사용해서 거슬러 준다.
 */
public class Change {
	public static void main(String[] args) {
		int[] arr = {1, 2, 5};
		System.out.println(new Change().solution(5, arr));
	}
	public int solution(int n, int[] money) {
		int[][] dp = new int[money.length][n+1];
		
		//money[0]만 이용해서 t원을 지불할 경우
		for(int t = 1; t <= n; t++) {
			if(t%money[0] == 0)
				dp[0][t] = 1;
		}
		//money[0..x]을 이용해서 t원을 지불할 경우
		for(int x = 1; x < money.length; x++) {
			dp[x][0] = 1;
			for(int t = 1; t <= n; t++) {
				if(money[x] > t) {
					dp[x][t] = dp[x-1][t];
				}else {
					dp[x][t] = dp[x-1][t] + dp[x][t - money[x]];
				}
			}
		}

		return dp[money.length-1][n];
	}
}
