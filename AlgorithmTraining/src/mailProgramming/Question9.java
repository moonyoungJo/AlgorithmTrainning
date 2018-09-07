package mailProgramming;

import java.util.Arrays;

/*
 * 정수 배열(int array)이 주어지면 0이 아닌 정수 순서를 유지하며 
 * 모든 0을 배열 오른쪽 끝으로 옮기시오. 
 * 단, 시간복잡도는 O(n), 공간복잡도는 O(1)여야 합니다.
 * 
 * Input: [0, 5, 0, 3, -1]
 * Output: [5, 3, -1, 0, 0]
 */
public class Question9 {
	public static void main(String[] args) {
		int[] arr = {0, 5, 0, 3, -1};
		System.out.println(Arrays.toString(calculate(arr)));
		
		int[] arr2 = {3, 0, 3};
		System.out.println(Arrays.toString(calculate(arr2)));
		
		int[] arr3 = {3, 0, 7, 0, 0, 0};
		System.out.println(Arrays.toString(calculate(arr3)));
	}
	
	public static int[] calculate(int[] arr) {
		int count = 0;
		int index = 0;
		
		while(count + index <= arr.length) {
			if(arr[index] == 0)
				count++;
			else {
				arr[index-count] = arr[index];
			}
			
			index++;
		}
		
		for(int i = index-count; i < arr.length; i++) {
			arr[i] = 0;
		}
		
		return arr;
	}
}
