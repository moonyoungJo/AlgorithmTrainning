package mailProgramming;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 정수 배열과 타겟 숫자가 주어지면, 
 * 합이 타겟값이 되는 두 원소의 인덱스를 찾으시오. 
 * 단, 시간복잡도 O(n) 여야 합니다.
 * 
 * 시간복잡도가 n이여야 하므로 탐색하는 자료구조가 중요하다. 
 * 해시를 사용하면 상수의 시간복잡도를 가지므로 이 문제의 해답이 될 수 있다.
 */
public class Question5 {
	public static void main(String[] args) {
		int[] arr = {2, 5, 6, 1, 10};
		int target = 8;
		System.out.println(Arrays.toString(calculate(arr, target)));
	}
	public static int[] calculate(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int value;
		for(int i = 0; i < arr.length; i++) {
			value = arr[i];
			if(map.containsKey(target - value)) {
				int[] ret = {map.get(target - value), i};
				return ret;
			}else {
				map.put(value, i);
			}
		}
		return null;
	}
}
