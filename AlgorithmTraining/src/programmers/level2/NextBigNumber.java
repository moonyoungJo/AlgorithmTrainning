package programmers.level2;

/*
 * 다음 큰 숫자 찾기
 */
public class NextBigNumber {
	public static void main(String[] args) {
		System.out.println((new NextBigNumber()).solution(4));
	}
	public int solution(int n) {
		int oneNum = getOneNum(n);
		return getNext(n, oneNum);
	}
	private int getOneNum(int n){
		int ret = 0;
		int r = 0;
		int s = n;
		
		while(true){
			r = s%2;
			s = s/2;
			
			if(r == 1)
				ret++;
			if(s == 0)
				return ret;
		}
		
	}
	private int getNext(int curr, int oneNum){
		int next = ++curr;
		
		while(true){
			int nextOneNum = getOneNum(next);
			if(oneNum == nextOneNum)
				return next;
			next++;
		}
	}
}
