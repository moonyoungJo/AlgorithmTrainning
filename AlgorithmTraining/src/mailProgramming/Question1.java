package mailProgramming;

/*
 * 정수 배열(int array)가 주어지면 가장 큰 이어지는 원소들의 합을 구하시오. 단, 시간복잡도는 O(n)
 * 
 * 풀이
 * 이전부터 더해왔던 값이 음수이면 뒤에 있는 값들을 더해간다고 한들 값을 떨어트리기만 한다.
 * 이 경우에는 새로 숫자를 새는 것이 더 큰 값이 나온다.
 * 만약 이전부터 더해왔던 값이 양수이면 어쩄든 뒤에 있는 값들과 더해지면 더 큰 값을 반환하므로 계속 세어도 된다.
 */
public class Question1 {
	public static void main(String[] args) {
		int[] arr1 = {-1, 3, -1, 5};
		System.out.println(calculate(arr1));
		int[] arr2 = {-5, -3, -1};
		System.out.println(calculate(arr2));
		int[] arr3 = {2, 4, -2, -3, 8};
		System.out.println(calculate(arr3));
	}
	public static int calculate(int[] arr) {
		int preMax = arr[0];
		int max = preMax;
		
		
		for(int i = 1; i < arr.length; i++) {
			if(preMax > 0)
				preMax += arr[i];
			else
				preMax = arr[i];
			
			if(max < preMax)
				max = preMax;
		}
		
		return max;
	}
}
