package programmers.level3;

/*
 * 계속되는 폭우로 일부 지역이 물에 잠겼습니다. 
 * 물에 잠기지 않은 지역을 통해 학교를 가려고 합니다. 
 * 집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.
 * 
 * 가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래, 
 * 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.
 * 
 * 격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 
 * 2차원 배열 puddles이 매개변수로 주어질 때, 
 * 학교에서 집까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를
 * return 하도록 solution 함수를 작성해주세요.
 * 
 * 풀이 : 최단거리를 계산 하는 문제이기 때문에 아래와 같이 for문 2개를 중첩해서 풀 수 있다.
 */
public class RoutesToSchool {
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		System.out.println(new RoutesToSchool().solution(m, n, puddles));
	}
	public int solution(int m, int n, int[][] puddles) {
		int[][] dp = new int[m][n];
		for(int[] puddle : puddles) {
			dp[puddle[0]-1][puddle[1]-1] = -1;	//웅덩이 체크
		}
		dp[0][0] = 1;
		
		for(int x = 0; x < m; x++) {
			for(int y=0; y < n; y++) {
				if(dp[x][y] == -1) {
					dp[x][y] = 0;
					continue;
				}
				
				if(x == 0 && y == 0)
					continue;
				
				int v = 0;
				if(x-1 >= 0)
					v += dp[x-1][y];
				if(y-1 >= 0)
					v += dp[x][y-1];
				dp[x][y] = v % 1000000007;
			}
		}
		
		
        return dp[m-1][n-1];
    }
}