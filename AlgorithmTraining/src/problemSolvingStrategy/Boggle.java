package problemSolvingStrategy;

import java.util.Scanner;

/*
 * 보글(Boggle) 게임은 그림 (a)와 같은 5x5 크기의 알파벳 격자인 
 * 게임판의 한 글자에서 시작해서 펜을 움직이면서 만나는 글자를 그 순서대로
 *  나열하여 만들어지는 영어 단어를 찾아내는 게임입니다. 펜은 상하좌우, 
 *  혹은 대각선으로 인접한 칸으로 이동할 수 있으며 글자를 건너뛸 수는 없습니다. 
 *  지나간 글자를 다시 지나가는 것은 가능하지만, 펜을 이동하지않고 같은 글자를 여러번 쓸 수는 없습니다.
 *  
 *  보글 게임판과 알고 있는 단어들의 목록이 주어질 때, 
 *  보글 게임판에서 각 단어를 찾을 수 있는지 여부를 출력하는 프로그램을 작성하세요.
 */
public class Boggle {
	public static int[][] matchSeq = {{-1, -1}, {0, -1}, {1, -1},
										{-1, 0}, {1, 0},
										{-1, 1}, {0, 1}, {1, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseN = sc.nextInt();
		for(int n = 0; n < caseN; n++) {
			char[][] board = new char[5][5];
			
			String line = null;
			for(int i = 0; i < 5; i++) {
				line = sc.next();
				for(int j = 0; j < 5; j++)
					board[i][j] = line.charAt(j);
			}
			
			int wordN = sc.nextInt();
			String input = null;
			for(int i = 0; i < wordN; i++) {
				input = sc.next();
				calculate(board, input);
			}
		}
	}
	
	public static void calculate(char[][] board, String input) {
		boolean ret = false;
		boolean[][][] dp = new boolean[5][5][input.length()];
		for(int x = 0; x < 5; x++) {
			for(int y = 0; y < 5; y++) {
				ret = subCalc(board, dp, input, x, y);
				if(ret) {
					System.out.println(input + " YES");
					return;
				}
			}
		}
		System.out.println(input + " NO");
	}
	//재귀적으로 체크하기. 이미 같은 문자열로 방문했던 곳인지 visited에서 확인해서 가지치기 한다.
	public static boolean subCalc(char[][] board, boolean[][][] visited, String rest, int x, int y) {
		
		if(rest.charAt(0) != board[x][y])
			return false;
		if(rest.length() == 1) {
			return true;
		}
		
		boolean ret;
		int nextX;
		int nextY;
		for(int i = 0; i < matchSeq.length; i++) {
			nextX = x + matchSeq[i][0];
			nextY = y + matchSeq[i][1];
			if(validXY(nextX, nextY) && !visited[nextX][nextY][rest.length()-2]) {
				ret = subCalc(board, visited, rest.substring(1), nextX, nextY);
				if(ret) {
					return true;
				}
			}
		}
		visited[x][y][rest.length()-1] = true;
		return false;
	}
	public static boolean validXY(int x, int y) {
		if(x < 0 || y < 0 || x >= 5 || y >= 5)
			return false;
		return true;
	}
}
