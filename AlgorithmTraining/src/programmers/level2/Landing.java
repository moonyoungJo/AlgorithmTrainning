package programmers.level2;

/*
 * 땅따먹기 게임을 하려고 합니다. 
 * 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 
 * 모든 칸에는 점수가 쓰여 있습니다. 
 * 1행부터 땅을 밟으며 한 행씩 내려올 때, 
 * 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다. 
 * 
 * 단, 땅따먹기 게임에는 한 행씩 내려올 때, 
 * 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
 * 
 * | 1 | 2 | 3 | 5 |
 * | 5 | 6 | 7 | 8 |
 * | 4 | 3 | 2 | 1 |
 * 
 * 로 땅이 주어졌다면, 
 * 1행에서 네번째 칸 (5)를 밟았으면, 
 * 2행의 네번째 칸 (8)은 밟을 수 없습니다.
 */
public class Landing {
	public static void main(String[] args) {
		int[][] land = {{1, 1, 1, 1},
						{1, 2, 2, 1},
						{1, 4, 4, 1}};
		System.out.println(new Landing().solution(land));
	}
	int solution(int[][] land) {
		int dp[] = new int[land[0].length];
		
		for(int i = 0; i < land[0].length; i++) {
			dp[i] = land[0][i];
		}
		
		
		for(int low = 1; low < land.length; low++) {
			int max = Integer.MIN_VALUE;
			int maxIndex = -1;
			int nextMax = Integer.MIN_VALUE;
			
			//이전 경로 중 점수가 가장 큰 경우, 그 다음 경우 찾기
			for(int prev = 0; prev < dp.length; prev++) {
				if(dp[prev] > max) {
					nextMax = max;
					max = dp[prev];
					maxIndex = prev;
				}else if(dp[prev] > nextMax) {
					nextMax = dp[prev];
				}
			}
			
			//계산
			for (int target = 0; target < land[low].length; target++) {
				if(maxIndex != target) {
					dp[target] = max + land[low][target];
				}else {
					dp[target] = nextMax + land[low][target];
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < dp.length; i++) {
			if(dp[i] > max)
				max = dp[i];
		}

		return max;
	}
}
