package programmers.level2;

/*
 * 올바른 괄호
 */
public class CorrectBracket {
	boolean solution(String s) {
		int left = 0;
		int pointer = 0;
		
		while(pointer < s.length()){
			char c = s.charAt(pointer);
			
			if(c == '('){
				left++;
			}else{
				if(left == 0)
					return false;
				left--;
			}
			
			pointer++;
		}
		
		if(left == 0)
			return true;
		return false;
	}
}
