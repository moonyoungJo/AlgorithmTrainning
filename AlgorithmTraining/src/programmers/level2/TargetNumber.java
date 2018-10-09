package programmers.level2;

/*
 * n개의 음이 아닌 정수가 있습니다. 
 * 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 * 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 
 * 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 
 * 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * DFS로 해결!
 */
public class TargetNumber {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(new TargetNumber().solution(numbers, target));
	}
	public int solution(int[] numbers, int target) {
        return subCalc(numbers, 0, target, 0);
    }
	public int subCalc(int[] numbers, int curr, int target, int pointer) {
		if(numbers.length == pointer) {
			if(curr == target)
				return 1;
			return 0;
		}
		
		int ret = subCalc(numbers, curr+numbers[pointer], target, pointer+1);
		ret += subCalc(numbers, curr-numbers[pointer], target, pointer+1);
		
		return ret;
	}
}