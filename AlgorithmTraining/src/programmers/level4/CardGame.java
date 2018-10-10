package programmers.level4;

/*
 * 카드게임
 * 
 * 카드게임이 있다. 
 * 게임에 사용하는 각 카드에는 양의 정수 하나가 적혀있고 같은 숫자가 적힌 카드는 여러 장 있을 수 있다. 
 * 게임방법은 우선 짝수개의 카드를 무작위로 섞은 뒤 같은 개수의 두 더미로 나누어 하나는 왼쪽에 다른 하나는 오른쪽에 둔다.
 * 각 더미의 제일 위에 있는 카드끼리 서로 비교하며 게임을 한다. 게임 규칙은 다음과 같다. 
 * 지금부터 왼쪽 더미의 제일 위 카드를 왼쪽 카드로, 오른쪽 더미의 제일 위 카드를 오른쪽 카드로 부르겠다.
 * 
 * 1. 언제든지 왼쪽 카드만 통에 버릴 수도 있고 왼쪽 카드와 오른쪽 카드를 둘 다 통에 버릴 수도 있다. 이때 얻는 점수는 없다.
 * 2. 오른쪽 카드에 적힌 수가 왼쪽 카드에 적힌 수보다 작은 경우에는 오른쪽 카드만 통에 버릴 수도 있다. 오른쪽 카드만 버리는 경우에는 오른쪽 카드에 적힌 수만큼 점수를 얻는다.
 * 3. (1)과 (2)의 규칙에 따라 게임을 진행하다가 어느 쪽 더미든 남은 카드가 없다면 게임이 끝나며 그때까지 얻은 점수의 합이 최종 점수가 된다.
 * 
 * 왼쪽 더미의 카드에 적힌 정수가 담긴 배열 left와 오른쪽 더미의 카드에 적힌 정수가 담긴 배열 right가 매개변수로 주어질 때, 
 * 얻을 수 있는 최종 점수의 최대값을 return 하도록 solution 함수를 작성하시오.
 * 
 */
public class CardGame {
	public static void main(String[] args) {
		int[] left = {3, 2, 5};
		int[] right = {2, 4, 1};
		System.out.println(new CardGame().solution(left, right));
	}
	public int solution(int[] left, int[] right) {
		//dp[a][b] : 왼쪽 a/오른쪽 b가 가장 위에 있을 때, 얻을 수 있는 최대 점수
		int[][] dp = new int[left.length][right.length];
		
		/*
		 * (left.length-1, right.length-1)
		 * (left.length-2, right.length-1), (left.length-1, right.length-2)
		 * ....
		 * (0, right.length-1) ... (left.length-1, 0)
		 */	
		int num = 1;
		for(int row = left.length-1; row >= 0 ; row--, num++) {
			for(int count = 0; count < num; count++) {
				subCalc(dp, left, right, row + count, right.length-1 -count);
			}		
		}
		num -= 2;
		
		/*
		 * (0, right.length-2) ... (left.length-2, 0)
		 * (0, right.length-3) ... (left.length-3, 0)
		 * ...
		 * (0, 1), (1, 0)
		 * (0, 0)
		 */
		for(int height = right.length-2; height >=  0; height--, num--) {
			for(int count = 0; count < num; count++) {
				subCalc(dp, left, right, count, height-count);
			}
		}

		
		return dp[0][0];	
	}
	public int subCalc(int[][] dp, int[] left, int[] right, int lPointer, int rPointer) {
		int subScore = 0;
		
		//왼쪽 버리기
		if(lPointer+1 != left.length) {
			subScore = dp[lPointer+1][rPointer];
		}
		
		//왼_오 버리기
		if(lPointer+1 != left.length && rPointer+1 != right.length) {
			subScore = subScore > dp[lPointer+1][rPointer+1] ? subScore : dp[lPointer+1][rPointer+1];
		}
		
		//점수 얻기
		if(left[lPointer] > right[rPointer]) {
			int tmp;
			
			if(rPointer+1 == right.length) //오른쪽점수를 얻은 뒤 더이상 얻을 수 있는 점수가 없음
				tmp = right[rPointer];
			else
				tmp = dp[lPointer][rPointer+1] + right[rPointer];
			subScore = tmp > subScore ? tmp : subScore;
		}
		

		dp[lPointer][rPointer] = subScore;
		return subScore;
	}
}