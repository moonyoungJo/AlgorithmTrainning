package mailProgramming;

/*
 * 정수(int)가 주어지면, 
 * 팰린드롬(palindrome)인지 알아내시오. 
 * 팰린드롬이란, 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어를 말합니다. 
 * 단, 정수를 문자열로 바꾸면 안됩니다.
 */
public class Question4 {
	public static void main(String[] args) {
		System.out.println(calculate(1221));
		System.out.println(calculate(12345));
		System.out.println(calculate(-101));
		System.out.println(calculate(11111));
		System.out.println(calculate(12421));
	}
	public static boolean calculate(int n) {
		if(n < 0 || n % 10 == 0)
			return false;
		else if(n < 10)
			return true;
		
		int rev = n % 10;
		int seq = n / 10;
		
		while(seq / rev >= 100) {
			rev = (rev * 10) + (seq % 10);
			seq = seq / 10;
		}
		if(seq / rev >= 10) {
			seq /= 10;
		}
		
		if(seq == rev)
			return true;
		
		return false;
	}
}
