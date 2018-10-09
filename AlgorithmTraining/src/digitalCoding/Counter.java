package digitalCoding;

import java.util.Scanner;

/*
 * N자리의 카운터가 있다.
 * 각 자리의 최대값은 임의로 주어지고,
 * 초기 상태도 주어진다.
 * count를 한번 누르면 가장 오른쪽 자리수 부터 1씩 증가한다.
 * R번 누르면 카운터의 상태는 어떻게 변하는지 출력하라.
 */
public class Counter {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		//각 자리의 최대값 입력받기
		int[] info = new int[N];
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			info[i] = sc.nextInt();
		}
		//초기 상태 입력받기
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
			if (info[i] < data[i]) {
				System.out.println("-1");
				return;
			}
		}
		
		//몇번 누르는지 입력받기
		int count = sc.nextInt();
		int div = 1;

		for (int i = N - 1; i > 0; i--) {
			div *= (info[i] + 1);
		}

		//index(가장 왼쪽 자리 수)부터 계산
		int index = 0;
		while (index != N) {
			//가장 끝 자리 수 일 경우
			if (index == N - 1) {
				add(info, data, index, count);
				break;
			}else{
				int rest = count / div;
				if (rest != 0) {
					add(info, data, index, rest);
					count -= (div * rest);
				}

			}
			div /= (info[index + 1] + 1);
			index++;
		}

		//출력
		StringBuilder sb = new StringBuilder("");
		for (int i : data) {
			sb.append(i);
		}
		System.out.println(sb.toString());

	}
	//target자리에 num을 더할때 올림 관계를 고려해서 어떻게 변할지 계산하기
	public static void add(int[] info, int[] data, int target, int num) {
		while (target >= 0) {
			data[target] += num;
			if (data[target] > info[target]) {
				num = 1;
				data[target] = data[target] - info[target] - 1;
			}else {
				break;
			}
			target--;
		}
	}
}
