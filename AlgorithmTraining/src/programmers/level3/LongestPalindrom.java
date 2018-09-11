package programmers.level3;

/*
 * 앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다.
 * 문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 
 * solution 함수를 완성해 주세요.
 * 예를들면, 문자열 s가 abcdcba이면 7을 return하고 abacde이면 3을 return합니다.
 */
public class LongestPalindrom {
	public static void main(String[] args) {
		System.out.println(new LongestPalindrom().solution("aaaa"));
	}
	public int solution(String s) {
		if(s.length() == 0)
			return 0;
		
		int max = 1;
		int leftIndex;
		int rightIndex;
		int palin;
		
		for(int center = 0; center <= s.length()-2; center++) {
			leftIndex = center-1;
			rightIndex = center+1;
			palin = 1;
			
			while(leftIndex >= 0 && rightIndex <= s.length()-1
					&& (s.charAt(leftIndex) == s.charAt(rightIndex))) {
				palin += 2;
				leftIndex--;
				rightIndex++;
				
			}
			if(max < palin)
				max = palin;
			
			leftIndex = center;
			rightIndex = center+1;
			palin = 0;
			while(leftIndex >= 0 && rightIndex <= s.length()-1
					&& (s.charAt(leftIndex) == s.charAt(rightIndex))) {
				palin += 2;
				leftIndex--;
				rightIndex++;
				
			}
			if(max < palin)
				max = palin;
		}

		return max;
	}
}
