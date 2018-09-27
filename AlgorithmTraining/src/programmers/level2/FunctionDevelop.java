package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 
 * 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 * 
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 
 * 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 각 배포마다 
 * 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 */
public class FunctionDevelop {
	public static void main(String[] args) {
		int[] progresses = {0, 0, 0};
		int[] speeds = {7, 50, 50};
		System.out.println(Arrays.toString(new FunctionDevelop().solution(progresses, speeds)));
	}
	public int[] solution(int[] progresses, int[] speeds) {
		LinkedList<Integer> list = new LinkedList<>();
		int index = 0;
		int count;
		int rest;
		int time;
		
		while(index < progresses.length) {
			rest = 100 - progresses[index];
			time = rest / speeds[index];
			if(rest % speeds[index] != 0)
				time++;
			
			for(int i = index; i < progresses.length; i++) {
				progresses[i] = progresses[i] + speeds[i]*time;
			}
			
			count = 1;
			index++;
			while(index< progresses.length && progresses[index] >= 100) {
				count++;
				index++;
			}
			list.add(count);
		}
		int[] answer = new int[list.size()];
		int pointer = 0;
		for(int v : list) {
			answer[pointer] = v;
			pointer++;
		}
		return answer;
	}
}
