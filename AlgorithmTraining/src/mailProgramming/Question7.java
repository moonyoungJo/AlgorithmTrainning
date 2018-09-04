package mailProgramming;

import java.util.StringTokenizer;

/*
 * 주어진 string 에 모든 단어를 거꾸로 하시오.
 */
public class Question7 {
	public static void main(String[] args) {
		System.out.println(calculate("abc 123 apple"));
	}
	public static String calculate(String s) {
		StringBuilder ret = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(s);
		
		while(tokenizer.hasMoreTokens()){
			String rev = reverse(tokenizer.nextToken());
			ret.append(rev + ' ');
		}
		ret.deleteCharAt(ret.length()-1);
		
		return ret.toString();
	}
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);	
		char tmp;
		
		for(int i = 0; i < s.length()/2; i++) { 
			tmp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(s.length()-1-i));
			sb.setCharAt(s.length()-1-i, tmp);
		}
		
		return sb.toString();
	}
	
}
