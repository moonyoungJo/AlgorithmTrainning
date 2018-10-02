package summerCoding;

/*
 * 기지국 설치
 * 
 * N개의 아파트가 일렬로 쭉 늘어서 있습니다. 
 * 이 중에서 일부 아파트 옥상에는 4g 기지국이 설치되어 있습니다. 
 * 기술이 발전해 5g 수요가 높아져 4g 기지국을 5g 기지국으로 바꾸려 합니다. 
 * 그런데 5g 기지국은 4g 기지국보다 전달 범위가 좁아, 4g 기지국을 5g 기지국으로 바꾸면 어떤 아파트에는 전파가 도달하지 않습니다.
 * 
 * 
 * 아파트의 개수 N, 
 * 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 stations, 
 * 전파의 도달 거리 W가 매개변수로 주어질 때, 
 * 모든 아파트에 전파를 전달하기 위해 증설해야 할 기지국 개수의 최솟값을 리턴하는 solution 함수를 완성해주세요
 * 
 * 주의 : 기지국의 시작번호가 1이다!
 */
public class BaseStation {
	public static void main(String[] args) {
		int N = 6;
		int[] stations = {2, 5};
		int W = 1;
		System.out.println(new BaseStation().solution(N, stations, W));
	}
	public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0;
        int stationPointer = 0;
        
        while(index < n) {
        	if(stationPointer < stations.length && index >= (stations[stationPointer]-1)-w) {
        		index = (stations[stationPointer]-1) + w + 1;
        		stationPointer++;
        	}else {
        		index = index + w*2+1;
        		answer++;
        	}
        }
        
        
        return answer;
    }
}