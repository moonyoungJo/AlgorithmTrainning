package summerCoding;

/*
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
 * nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 
 * 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 */
public class MakePrimeNumber {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println(new MakePrimeNumber().solution(nums));
	}
	public int solution(int[] nums) {

		return calc(nums, 0, 3, 0);
	}
	//start부터 3개 고르고 소수인지 판단하기
	public int calc(int[] nums, int start, int num, int curr) {
		if(num == 0) {
			return isPrime(curr)? 1 : 0;
		}
		int ret = 0;
		ret += calc(nums, start+1, num-1, curr+nums[start]);
		if(start+num < nums.length)
			ret +=calc(nums, start+1, num, curr);
		
		return ret;
	}
	public boolean isPrime(int n) {
		for(int i = 2; i <= n/2; i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
}
