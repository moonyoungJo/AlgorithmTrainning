package programmers.level2;

/*
 * 가장 큰 정사각형 찾기
 * 동적프로그래밍을 이용하면 쉽게 해결가능합니다.
 */
public class BiggestSquare {
	public static void main(String[] args) {
		int[][] board = {{0, 1, 1, 1}, 
						 {1, 1, 1, 1},
						 {1, 1, 1, 1},
						 {0, 0, 1, 1}};
		System.out.println((new BiggestSquare()).solution(board));
	}
	private int max = 0;
	public int solution(int [][]board)
    {
        int[][] dBoard = new int[board.length][board[0].length];
        
        for(int i = 0; i < board[0].length; i++){
        	if(max == 0 &&(board[0][i] == 1))
        		max = 1;
        	dBoard[0][i] = board[0][i];
        }
       
        for(int i = 1; i < board.length; i++){
        	dBoard[i][0] = board[i][0];
        	if(max == 0 &&(board[i][0] == 1))
        		max = 1;
       
        	for(int j = 1; j < board[i].length; j++){
        		calc(board, dBoard, i, j);
        	}
        }

        return max*max;
    }
	public void calc(int[][] board, int[][]dBoard, int x, int y){
		if(board[x][y] == 0){
			board[x][y] = 0;
		}else{
			int min = Math.min(dBoard[x-1][y], dBoard[x][y-1]);
			min = Math.min(min, dBoard[x-1][y-1]);
			min = min==0 ? 1 : min+1;

			dBoard[x][y] = min;
			
			if(max < min)
				max = min;
		}
	}
}
