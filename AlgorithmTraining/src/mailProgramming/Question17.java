package mailProgramming;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 0과 1로 만들어진 2D 정수 배열이 있습니다. 
 * 0은 장애물이고 1은 도로일때, 두 좌표가 주어지면, 
 * 첫번째 좌표에서 두번째 좌표까지 가장 가까운 거리를 구하시오. 
 * 두 좌표는 모두 도로에서 시작되고 좌, 우, 아래, 위로 움직이며 
 * 대각선으로는 움직일 수 없습니다. 만약 갈 수 없다면 -1을 리턴하시오.
 * 
 * dp와 큐를 통해 해결
 * 다음 갈 위치를 큐에 넣는다. 
 */
public class Question17 {
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) {
		int[][] input = {{1, 0, 0, 1, 1, 0},
						{1, 0, 0, 1, 0, 0},
						{1, 1, 1, 1, 0, 0},
						{1, 0, 0, 0, 0, 1},
						{1, 1, 1, 1, 1, 1}};
		System.out.println(calc(input, 0, 0, 0, 4));
		
	}
	public static int calc(int[][] path, int startX, int startY, int endX, int endY) {
		int[][] dp = new int[path.length][path[0].length];
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		Deque<Data> queue = new LinkedList<>();
		queue.add(new Data(startX, startY, 0));
		dp[startX][startY] = 0;
		int curX;
		int curY;
		int value;
		Data data;
		int afterX;
		int afterY;
		
		while(!queue.isEmpty()) {
			data = queue.poll();
			curX = data.x;
			curY = data.y;
			value = data.value;
			value++;
			
			for(int i = 0; i < dx.length; i++) {
				afterX = curX + dx[i];
				afterY = curY + dy[i];
				
				if(afterX >= 0 && afterX < path.length && 
						afterY >= 0 && afterY < path[0].length &&
						path[afterX][afterY] == 1 && dp[afterX][afterY] == -1) {
					dp[afterX][afterY] = value;
					queue.push(new Data(afterX, afterY, value));
				}
			}
		}
		
		
		return dp[endX][endY];
	}
}
class Data{
	int x;
	int y;
	int value;
	Data(int x, int y, int value){
		this.x = x;
		this.y = y;
		this.value = value;
	}
}
