package mailProgramming;

/*
 * 2차 정수 배열(2D int array)가 주어지면, 소용돌이 모양으로 원소들을 프린트하시오. 
 */
public class Question19 {
	public static int[] dirR = {0, 1, 0, -1};
	public static int[] dirC = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		int[][] input = {{1, 2, 3},
							{4, 5, 6},
							{7, 8, 9}};
		int[][] input2 = {{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
		calc(input);
		calc(input2);
	}
	public static void calc(int[][] input) {
		for(int[] line : input) {
			for(int v : line) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 0; i < input[0].length; i++) {
			System.out.print(input[0][i] + " ");
		}
		
		int curR = 0;
		int curC = input[0].length-1;
		int dir = 1;
		int count = 1;
		
		while(true) {
			if(input.length-count == 0 || input[0].length-count == 0) {
				break;
			}
			for(int i = 0; i < input.length-count; i++) {
				curR += dirR[dir];
				curC += dirC[dir];
				System.out.print(input[curR][curC] +" ");
			}
			dir = (dir+1)%dirR.length;
			for(int i = 0; i < input[0].length-count; i++) {
				curR += dirR[dir];
				curC += dirC[dir];
				System.out.print(input[curR][curC] +" ");
			}
			dir = (dir+1)%dirR.length;	
			count++;
		}
		System.out.println();
		System.out.println();
	}
}
