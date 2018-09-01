package programmers.level2;

/*
 * 124 나라의 숫자
 * 1 -> 1
 * 2 -> 2
 * 3 -> 4
 * 4 -> 11
 * 5 -> 12
 * 6 -> 14
 * ...
 * 
 * 즉 3으로 나눠 떨어지는 부분을 제외하면 3진수랑 비슷하다.
 * 나타내는 수/ 3진수 / 124
 * 3 -> 10 -> 4
 * 6 -> 20 -> 14
 * 9 -> 100 -> 24
 * 12 -> 110 -> 44
 * 에서 규칙성을 찾을 수 있다.
 */

public class Country124 {
	public static void main(String[] args) {
		int n = 4;
		System.out.println((new Country124()).solution(n));
	}
	public String solution(int n) {
		Character[] symbol = {'4', '1', '2'};
		StringBuilder ret = new StringBuilder("");
		int rest = 0;
		int share = n;
		
		while(share > 0){
			rest = share%3;
			share = share/3;
			
			if(rest == 0)
				share--;
			ret.insert(0,  symbol[rest]);
		}
		
		
		return ret.toString();
	}
}
