package programmers.level3;

/*
 * 타일 장식물
 * 
 * 대구 달성공원에 놀러 온 지수는 최근에 새로 만든 타일 장식물을 보게 되었다.
 *  타일 장식물은 정사각형 타일을 붙여 만든 형태였는데,
 *  한 변이 1인 정사각형 타일부터 시작하여 마치 앵무조개의 
 *  나선 모양처럼 점점 큰 타일을 붙인 형태였다. 
 * 
 * 지수는 문득 이러한 타일들로 구성되는 큰 직사각형의 둘레가 궁금해졌다. 
 * 예를 들어, 처음 다섯 개의 타일이 구성하는 
 * 직사각형(위에서 빨간색으로 표시한 직사각형)의 둘레는 26이다.
 * 타일의 개수 N이 주어질 때, 
 * N개의 타일로 구성된 직사각형의 둘레를 return 하도록 
 * solution 함수를 작성하시오.
 * 
 * 주의 : return type이 long임에 주의하자
 */
public class TileDecoration {
	public static void main(String[] args) {
		System.out.println(new TileDecoration().solution(6));
	}
	public long solution(int N) {
		if(N == 1)
			return 4;
		
        long width = 1;
        long preWidth = 1;
        long tmp;
        
        for(int i = 3; i <= N; i++) {
        	tmp = width + preWidth;
        	preWidth = width;
        	width = tmp;
        }
        
        
        return (width*2 + preWidth)*2;
    }
}