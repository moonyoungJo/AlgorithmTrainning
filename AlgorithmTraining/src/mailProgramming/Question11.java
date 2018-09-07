package mailProgramming;

import java.util.HashMap;
import java.util.Map;

/*
 * 길이가 같은 두 문자열(string) A 와 B가 주어지면, 
 * A 가 B 로 1:1 암호화 가능한지 찾으시오.
 * 
 * Input: “EGG”, “FOO”
 * Output: True // E->F, G->O
 */
public class Question11 {
	public static void main(String[] args) {
		String s1 = "EGG";
		String s2 = "FOO";
		System.out.println(calculate(s1, s2));
		
		s1 = "ABBCD";
		s2 = "APPLE";
		System.out.println(calculate(s1, s2));
		
		s1 = "AAB";
		s2 = "FOO";
		System.out.println(calculate(s1, s2));
	}
	public static boolean calculate(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		
		Map<Character, Character> charMap = new HashMap<>();
		char c1;
		char c2;
		
		for(int index = 0; index < s1.length(); index++) {
			c1 = s1.charAt(index);
			c2 = s2.charAt(index);
			
			if(charMap.containsKey(c1)) {
				if(charMap.get(c1) != c2)
					return false;
			}else {
				charMap.put(c1, c2);
			}
		}
		
		return true;
	}
}
