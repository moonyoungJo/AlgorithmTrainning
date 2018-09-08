package programmers.level2;

/*
 * Finn은 요즘 수학공부에 빠져 있습니다. 
 * 수학 공부를 하던 Finn은 자연수 n을 연속한 
 * 자연수들로 표현 하는 방법이 여러개라는 
 * 사실을 알게 되었습니다. 
 * 
 * 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
 * 
 * 1 + 2 + 3 + 4 + 5 = 15
 * 4 + 5 + 6 = 15
 * 7 + 8 = 15
 * 15 = 15
 */
public class ExpressionOfNumber {
	public static void main(String[] args) {
		System.out.println(new ExpressionOfNumber().solution(15));
	}
	
	//n = c * s + t(0+1+2+..+c-1) = s + s+1 + s+2 + ... + s+c-1
	public int solution(int n) {
		int c = 2;
		int t = 1;
		int ret = 1;
		
		while(c + t <= n) {
			if((n-t)%c == 0)
				ret++;
			
			t += c;
			c++;
		}
		
		return ret;
	}
}
