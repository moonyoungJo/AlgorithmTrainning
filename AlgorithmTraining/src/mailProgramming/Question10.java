package mailProgramming;

import java.util.HashSet;
import java.util.Set;

/*
 * String이 주어지면, 중복된 char가 없는 
 * 가장 긴 서브스트링 (substring)의 길이를 찾으시오.  
 * 
 * Input: “aabcbcbc”
 * Output: 3 // “abc”
 */
public class Question10 {
	public static void main(String[] args) {
		String s = "aabcbcbc";
		System.out.println(calculate(s));
		s = "aaaaaaaa";
		System.out.println(calculate(s));
		s = "abbbcedd";
		System.out.println(calculate(s));
	}
	public static int calculate(String s) {
		int index = 0;
		int max = 0;
		int currL = 0;
		Set<Character> charSet;
		
		while(index < s.length() && s.length() - index > max) {
			currL = 1;
			charSet = new HashSet<Character>();
			charSet.add(s.charAt(index));
			int pointer = index+1;
			
			
			while(pointer < s.length() && !charSet.contains(s.charAt(pointer))) {
				charSet.add(s.charAt(pointer));
				currL++;
				pointer++;
			}
			
			if(max < currL)
				max = currL;
			
			index++;
		}
		
		return max;
	}
}
