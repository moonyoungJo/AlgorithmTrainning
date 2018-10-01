package summerCoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/*
 * 영어 끝말 잇기
 * 
 * 1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 
 * 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.
 * 
 * 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
 * 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
 * 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
 * 이전에 등장했던 단어는 사용할 수 없습니다.
 * 한 글자인 단어는 인정되지 않습니다.
 * 다음은 3명이 끝말잇기를 하는 상황을 나타냅니다.
 * 
 * tank → kick → know → wheel → land → dream → mother → robot → tank
 * 
 * 위 끝말잇기는 다음과 같이 진행됩니다.
 * 끝말잇기를 계속 진행해 나가다 보면, 
 * 3번 사람이 자신의 세 번째 차례에 말한 tank 라는 단어는 이전에 등장했던 단어이므로 탈락하게 됩니다.
 * 
 * 사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때, 
 * 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 
 * return 하도록 solution 함수를 완성해주세요.
 * 
 * 풀이 : 문제대로 코드를 짜면 됩니다!
 */
public class WordChain {
	public static void main(String[] args) {
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		System.out.println(Arrays.toString(new WordChain().solution(3, words)));
	}
	public int[] solution(int n, String[] words) {
		int count = 1;
		int index = 0;
		int pointer = 0;
		HashMap<Character, TreeSet<String>> map = new HashMap<>();
		TreeSet<String> set;
		String word;
		char preC = words[pointer].charAt(0);
		
		while(pointer < words.length) {
			word = words[pointer];
			
			if(preC !=word.charAt(0)) {
				int[] answer = {index+1, count};
				return answer;
			}
			
			if(!map.containsKey(word.charAt(0))) {
				set = new TreeSet<>();
				set.add(word);
				map.put(word.charAt(0), set);
			}else {
				set = map.get(word.charAt(0));
				if(set.contains(word)) {
					int[] answer = {index+1, count};
					return answer;
				}
				set.add(word);
			}
			
			preC = word.charAt(word.length()-1);
			pointer++;
			++index;
			if(index >= n) {
				index -= n;
				count++;
			}
		}
		
		int[] answer = {0, 0};
		return answer;
    }
}
