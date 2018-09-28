package programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 모의고사
 * 
 * 수포자는 수학을 포기한 사람의 준말입니다. 
 * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * 
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */
public class MockTest {
	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		System.out.println(Arrays.toString(new MockTest().solution(answers)));
	}
	public static int[] p1 = {1, 2, 3, 4, 5};
	public static int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
	public static int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	public int[] solution(int[] answers) {
		int pointer1 = 0;
		int pointer2 = 0;
		int pointer3 = 0;
		int index = 0;
		int[] score = new int[4];
		
		while(answers.length > index) {
			
			if(p1[pointer1] == answers[index])
				score[1]++;
			if(p2[pointer2] == answers[index])
				score[2]++;
			if(p3[pointer3] == answers[index])
				score[3]++;
			
			pointer1 = (++pointer1)%p1.length;
			pointer2 = (++pointer2)%p2.length;
			pointer3 = (++pointer3)%p3.length;;
			index++;
		}
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		pQueue.add(1);
		for(int i = 2; i <= 3; i++) {
			if(score[i] > score[pQueue.peek()]) {
				pQueue.clear();
				pQueue.add(i);
			}else if(score[i] == score[pQueue.peek()]){
				pQueue.add(i);
			}		
		}
		int[] answer = new int[pQueue.size()];
		index = 0;
		for(int v : pQueue) {
			answer[index] = v;
			index++;
		}
		
		return answer;
	}
}
