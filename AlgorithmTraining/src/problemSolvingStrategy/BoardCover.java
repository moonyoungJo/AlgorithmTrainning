package problemSolvingStrategy;

import java.util.Scanner;

/*
 * H*W 크기의 게임판이 있습니다. 
 * 게임판은 검은 칸과 흰 칸으로 구성된 격자 모양을 하고 있는데 
 * 이 중 모든 흰 칸을 3칸짜리 L자 모양의 블록으로 덮고 싶습니다. 
 * 이 때 블록들은 자유롭게 회전해서 놓을 수 있지만, 서로 겹치거나, 
 * 검은 칸을 덮거나, 게임판 밖으로 나가서는 안 됩니다. 
 * 
 * 게임판이 주어질 때 이를 덮는 방법의 수를 계산하는 프로그램을 작성하세요.
 */
public class BoardCover {
	private static int[][][] type = {{{1, 0},{1, 1}},
										{{0, 1},{1, 0}},
										{{0, 1},{1, 1}},
										{{1, -1}, {1, 0}}};
	private static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseN = sc.nextInt();
		int h;
		int w;
		String line;
		
		for(int i = 0; i < caseN; i++) {
			h = sc.nextInt();
			w = sc.nextInt();
			
			boolean[][] board = new boolean[h][w];
			
			for(int j = 0; j < h; j++) {
				line = sc.next();
				
				for(int k = 0; k < w; k++) {
					if(line.charAt(k) == '#')
						board[j][k] = true;
				}
			}
			System.out.println(calculate(board));
			
		}
	}
	public static int calculate(boolean[][] board) {
		result = 0;
		int startX;
		int startY;
		boolean pass = false;
		
		for(int h = 0; h < board.length; h++) {
			for(int w = 0; w < board[0].length; w++) {
				if(!board[h][w]) {
					subCalculate(board, h, w);
					pass = true;
					break;
				}
			}
			if(pass)
				break;
		}
		
		return result;
	}
	public static void subCalculate(boolean[][] board, int h, int w) {
		
		for(int typeN = 0; typeN < type.length; typeN++) {
			//check valid
			if(!(h + type[typeN][0][0] >=0 && h + type[typeN][0][0] < board.length 
				&& w + type[typeN][0][1] >=0 && w + type[typeN][0][1] < board[0].length
				&& h + type[typeN][1][0] >=0 && h + type[typeN][1][0] < board.length
				&& w + type[typeN][1][1] >=0 && w + type[typeN][1][1] < board[0].length
				&& board[h + type[typeN][0][0]][w + type[typeN][0][1]] == false 
				&& board[h + type[typeN][1][0]][w + type[typeN][1][1]] == false))
				continue;
			board[h][w] = true;	
			board[h + type[typeN][0][0]][w + type[typeN][0][1]] = true;
			board[h + type[typeN][1][0]][w + type[typeN][1][1]] = true;
			
			//next calculate
			int nextH = 0;
			int nextW = 0;
			boolean pass = false;
			for(nextH = h; nextH < board.length; nextH++) {
				for(nextW = 0; nextW < board[0].length; nextW++) {
					if(!board[nextH][nextW]) {
						subCalculate(board, nextH, nextW);
						pass = true;
						break;
					}
				}
				if(pass)
					break;
			}
			
			//for next case
			board[h][w] = false;
			board[h + type[typeN][0][0]][w + type[typeN][0][1]] = false;
			board[h + type[typeN][1][0]][w + type[typeN][1][1]] = false;
			
			//if complete case
			if(nextH >= board.length && nextW >= board[0].length) {
				result++;
				break;
			}
		}		
	}
}
