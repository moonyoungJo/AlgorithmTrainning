package programmers.mockTest;

/*
 * 버스정류장 N개가 있습니다.
 * 각 정류장에는 1번부터 N번까지의 번호가 매겨져 있습니다. 
 * 2차원 배열로 주어진 정류장 표지판(signs)에는 A번 정류장에서 B번 정류장으로 가는 버스가 있다면 1, 
 * 없다면 0으로 표시되어 있습니다.
 * 
 * 예를 들어, 3개의 버스정류장이 있을 때
 * [[0, 1, 0]
 *  [0, 0, 1]
 *  [1, 0, 0]]
 * 으로 표시된 정류장 표시판이 주어진다면,
 * 
 * 1번 정류장에서 2번 정류장으로 갈 수 있습니다. (A=1, B=2)
 * 2번 정류장에서 3번 정류장으로 갈 수 있습니다. (A=2, B=3)
 * 3번 정류장에서 1번 정류장으로 갈 수 있습니다. (A=3, B=1)
 * 
 * 또한, 버스를 갈아타는 것이 가능합니다. 
 * 예를 들어, 위 예시에서는 1번에서 2번 정류장으로, 
 * 그리고 2번에서 3번 정류장으로 가는 버스가 있으므로, 한 번 갈아타서 1번에서 3번 정류장으로 갈 수 있습니다. 
 * 버스는 여러번 갈아타는 것이 가능합니다.
 * 
 * 우리는 이 표를 이용해서 특정 정류장 A에서 특정 정류장 B로 갈 수 있는지 판단하여, 
 * 갈 수 있으면 1, 갈 수 없으면 0으로 표시하려고 합니다.
 * 
 * 위 예시에서는
 * [[1, 1, 1]
 *  [1, 1, 1]
 *  [1, 1, 1]]
 * 을 return 해야 합니다.
 */
public class Problem3 {
	int[][] solution(int n, int[][] signs) {
		//answer에 signs 복사
		int[][] answer = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				answer[i][j] = signs[i][j];
		
		//mid 정류장을 거쳐갈 때, 갈 수 있는지 여부 검사
		for (int mid = 0; mid < n; mid++) {
			for (int start = 0; start < n; start++) {
				//mid 정류장에 도달할 수 없거나 mid가 본인인 경우
				if (mid == start || answer[start][mid] == 0)
					continue;

				for (int dest = 0; dest < n; dest++)
					answer[start][dest] = answer[start][dest] | answer[mid][dest];
			}
		}

		return answer;
	}
}
