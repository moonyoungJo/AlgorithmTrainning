package mailProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 간격(interval)로 이루어진 배열이 주어지면, 
 * 겹치는 간격 원소들을 합친 새로운 배열을 만드시오. 
 * 간격은 시작과 끝으로 이루어져 있으며 시작은 끝보다 작거나 같습니다.
 * 
 * 
 * 예시
 * Input: {{2,4}, {1,5}, {7,9}}
 * Output: {{1,5}, {7,9}}
 * 
 * 
 * Input: {{3,6}, {1,3}, {2,4}}
 * Output: {{1,6}}
 */
public class Question6 {
	public static void main(String[] args) {
		int[][] arr1 = {{2, 4}, {1, 5}, {7, 9}};
		List<Pair> result = calculate(arr1);		
		for(Pair p : result) {
			System.out.println(p.n1 + "  " + p.n2);
		}
		System.out.println();
		
		int[][] arr2 = {{3, 6}, {1, 3}, {2, 4}};
		result = calculate(arr2);
		for(Pair p : result) {
			System.out.println(p.n1 + "  " + p.n2);
		}
	}
	public static List<Pair> calculate(int[][] arr) {
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		LinkedList<Pair> result = new LinkedList<>();
		
		for(int i = 0; i < arr.length; i++) {
			queue.add(new Pair(arr[i][0], arr[i][1]));
		}
		
		Pair pair = queue.poll();
		int start = pair.n1;
		int end = pair.n2;
		
		while(!queue.isEmpty()) {
			pair = queue.poll();
			
			if(pair.n1 <= end) {
				if(pair.n2 > end)
					end = pair.n2;
			}else {
				
				result.add(new Pair(start, end));
				start = pair.n1;
				end = pair.n2;
			}
		}
		result.add(new Pair(start, end));
		
		return result;
	}
}
class Pair implements Comparable<Pair>{
	int n1;
	int n2;
	
	Pair(int n1, int n2){
		this.n1 = n1;
		this.n2 = n2;
	}
	@Override
	public int compareTo(Pair p) {
		return n1 - p.n1;
	}
}
