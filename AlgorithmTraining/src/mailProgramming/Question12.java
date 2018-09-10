package mailProgramming;

import java.util.Arrays;

/*
 * 정수로된 배열이 주어지면, 각 원소가 자신을 뺀 나머지 원소들의 곱셈이 되게하라.
 * 단, 나누기 사용 금지, O(n) 시간복잡도
 * 
 * 예제)
 * input: [1, 2, 3, 4, 5]
 * output: [120, 60, 40, 30, 24]
 * 
 * pre = [ 1,
 *         array[0],
 *         array[0] * array[1],
 *         array[0] * array[1] * array[2],
 *         array[0] * array[1] * array[2] * array[3] ]
 *
 * after = [ array[1] * array[2] * array[3] * array[4],
 *           array[2] * array[3] * array[4] ,
 *           array[3] * array[4] ,
 *           array[4],
 *          1]
 */
public class Question12 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(calculate(arr)));
	}
	public static int[] calculate(int[] arr) {
		int[] pre = new int[arr.length];
		int[] after = new int[arr.length];
		
		int value = 1;
		for(int i = 0; i < arr.length; i++) {
			pre[i] = value;
			value *= arr[i];
		}
		value = 1;
		for(int i = arr.length-1; i >= 0; i--) {
			after[i] =value;
			value *= arr[i];
		}
		
		int[] ret = new int[arr.length];
		for(int i = 0; i < ret.length; i++) {
			ret[i] = pre[i] * after[i];
		}
		return ret;
	}
}
