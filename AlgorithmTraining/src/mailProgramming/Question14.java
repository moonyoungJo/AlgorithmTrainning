package mailProgramming;

public class Question14 {
	public static void main(String[] args) {
		String[] words = {"apple", "apps", "ape"};
		System.out.println(calculate(words));
	}
	public static int calculate(String[] words) {
		
		int minLength = Integer.MAX_VALUE;
		for(int i = 0; i < words.length; i++) {
			if(minLength > words[i].length())
				minLength = words[i].length();
		}
		
		int count = 0;
		for(int index = 0; index < minLength; index++) {
			char c = words[0].charAt(index);
			boolean out = false;
			for(int word = 1; word < words.length; word++) {
				if(words[word].charAt(index) != c) {
					out = true;
					break;
				}
			}
			
			if(out)
				break;
			count++;
		}
		
		return count;
	}
}
