package mailProgramming;

import java.util.LinkedList;

/*
 * 정수 n이 주어지면, 
 * n개의 여는 괄호 "("와 n개의 닫는 괄호 ")"로 
 * 만들 수 있는 괄호 조합을 모두 구하시오.(시간 복잡도 제한 없습니다).
 * 
 * Input: 3
 * Output: ["((()))", "(()())", "()(())", "(())()", "()()()"]
 */
public class Question3 {
	public static void main(String[] args) {
		
	}
	public static String[] calculate(int n) {
		
		return null;
	}
	public static void selectBracket(int n, int left, int right, String s, LinkedList<String> result) {
		if(n == 0) {
			result.add(s);
			return;
		}
		
		if(left == right) {
			selectBracket(n-1, left+1, right, s + "(", result);
		}else {
			selectBracket(n-1, left+1, right, s + "(", result);
			selectBracket(n-1, left, right+1, s + ")", result);
		}
		
	}
}
