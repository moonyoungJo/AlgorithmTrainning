package programmers.level3;

/*
 * 가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다. 
 * 이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다. 
 * 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.
 * 
 * 타일을 가로로 배치 하는 경우
 * 타일을 세로로 배치 하는 경우
 * 
 * 직사각형의 가로의 길이 n이 매개변수로 주어질 때, 
 * 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.
 * 
 * 제한사항
 * 가로의 길이 n은 60,000이하의 자연수 입니다.
 * 경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.
 * 
 * 
 * 풀이
 * 가로로 누은 타일의 경우 반듯이 두개를 붙여서 쓸 수 밖에 없다. 그러므로 2*2 크기의 타일하나로 가정해도 같은 문제가 된다.
 * 1과 2를 조합해서 n을 어떻게 구성하는지를 구하면 된다.
 */
public class Tiling2n {
	public int solution(int n) {
		if(n <= 2)
			return n;
		
		int before2 = 1;
		int before1 = 2;
		int targetResult = 0;
		
		for(int target = 3; target <= n; target++) {
			targetResult = (before1 + before2)% 1000000007;
			before2 = before1;
			before1 = targetResult;
		}
		return targetResult;
	}
	public static void main(String[] args) {
		System.out.println(new Tiling2n().solution(4));
	}
}
