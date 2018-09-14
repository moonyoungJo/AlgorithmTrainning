package programmers.level2;

import java.util.Arrays;

/*
 * 전화번호부에 적힌 전화번호 중, 
 * 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 
 * 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * 
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phoneBook 이 
 * solution 함수의 매개변수로 주어질 때, 
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 
 * 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 사항
 * phoneBook의 길이는 1 이상, 100 이하입니다.
 * 각 전화번호의 길이는 1 이상, 20 이하입니다.
 * 
 * 
 * 풀이
 * 사전순으로 정렬하고 이웃한 두 요소를 비교한다
 */
public class PhoneNumberList {
	public static void main(String[] args) {
		String[] s1 = {"119", "97674223", "1195524421"};
		
		System.out.println(new PhoneNumberList().solution(s1));
	}
	public boolean solution(String[] phoneBook) {
		Arrays.sort(phoneBook);
		
		for(int i = 0; i < phoneBook.length-1; i++) {
			if(phoneBook[i].length() <= phoneBook[i+1].length()) {
				String s1 = phoneBook[i];
				String s2 = phoneBook[i+1];
				s2 = s2.substring(0, s1.length());
				if(s1.equals(s2))
					return false;
			}
		}
		return true;
	}
}
