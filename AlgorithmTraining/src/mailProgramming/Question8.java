package mailProgramming;

/*
 * 정수 배열(int array)이 주어지면 두번째로 큰 값을 프린트하시오.
 */
public class Question8 {
	public static void main(String[] args) {
		int[] arr1 = {10, 5, 4, 3, -1};
		System.out.println(calculate(arr1));
		
		int[] arr2 = {3, 3, 3};
		System.out.println(calculate(arr2));
	}
	public static int calculate(int[] arr) {
		if(arr.length < 2) {
			return -1;
		}
		
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int value;
		
		for(int i = 0; i < arr.length; i++) {
			value = arr[i];
			if(value >= max) {
				secondMax = max;
				max = value;
			}else if(value >= secondMax) {
				secondMax = value;
			}
		}
		
		if(max == secondMax)
			return -1;
		
		return secondMax;
	}
}
