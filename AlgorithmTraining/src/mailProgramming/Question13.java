package mailProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 정수 배열(int array)과 정수 N이 주어지면, N번째로 큰 배열 원소를 찾으시오.
 * 
 * Input: [-1, 3, -1, 5, 4], 2
 * Output: 4
 */
public class Question13 {
	public static void main(String[] args) {
		int[] arr = {-1, 3, -1, 5, 4};
		System.out.println(calculate(arr, 4));
	}
	public static int calculate(int[] arr, int n) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}			
		});
		
		for(int v : arr) {
			pQueue.add(v);
		}
		for(int i = 1; i < n; i++) {
			pQueue.poll();
		}
		return pQueue.poll();
	}
}
