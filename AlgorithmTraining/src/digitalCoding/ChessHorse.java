package digitalCoding;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * w*h 체스판이 주어질 때 체스의 말이 
 * 모든 칸에 도달할 수 있는지 여부를 T,F로 나타내고,
 * 
 * 가장 여러번 움직여서 도달할 수 있는 칸에 도달하려면
 * 몇번 움직여야 하는지 출력하라
 * 
 */
public class ChessHorse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();

		int[][] map = new int[w][h];
		int count = 0;
		
		//말이 움직일 수 있는 정보
		int[] dw = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int[] dh = { 1, 2, 2, 1, -1, -2, -2, -1 };

		int max = Integer.MIN_VALUE;
		String result = "F";
		LinkedList<Point> list = new LinkedList<>();	//방문할 위치들
		//첫번째 위치 넣어두기 - 다른 위치들과 구분하기 위해 1부터 시작  --> 반드시 답을 출력하기 전에 -1 해줄 것
		map[0][0] = 1;
		list.add(new Point(0, 0, 1));

		//list가 빌때까지 수행
		while (!list.isEmpty()) {
			Point p = list.poll();
			map[p.w][p.h] = p.count;

			if (p.count > max)
				max = p.count;
			count++;

			if (count == w * h) {
				result = "T";
				break;
			}

			//방문해야할 위치(=도달가능한 위치)들 탐색
			for (int i = 0; i < dw.length; i++) {
				if (p.w + dw[i] >= 0 && p.w + dw[i] < w && p.h + dh[i] >= 0 && p.h + dh[i] < h
						&& map[p.w + dw[i]][p.h + dh[i]] == 0) {
					map[p.w + dw[i]][p.h + dh[i]] = count + 1;
					list.add(new Point(p.w + dw[i], p.h + dh[i], p.count + 1));
				}
			}
		}

		System.out.println(result + (max - 1));
	}
}

//위치정보
class Point {
	int w;
	int h;
	int count;

	Point(int w, int h, int count) {
		this.w = w;
		this.h = h;
		this.count = count;
	}
}
