package mailProgramming;

/*
 * 피보나치 배열은 0과 1로 시작하며, 
 * 다음 피보나치 수는 바로 앞의 두 피보나치 수의 합이 된다. 
 * 정수 N이 주어지면, N보다 작은 모든 짝수 피보나치 수의 합을 구하여라.
 */
public class Question2 {
	public static void main(String[] args) {
		System.out.println(calculate(12));
	}
	public static int calculate(int input) {
		int n1 = 0;
		int n2 = 1;
		int ret = 0;
		int tmp = 0;
		
		while(n2 < input) {
			if(n2%2 == 0)
				ret += n2;
			tmp = n1 + n2;
			n1 = n2;
			n2 = tmp;
		}
		
		return ret;
	}
}
