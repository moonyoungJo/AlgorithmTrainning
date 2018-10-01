package summerCoding;

import java.util.HashSet;
import java.util.Set;

/*
 * N개의 마을로 이루어진 나라가 있습니다. 
 * 이 나라의 각 마을에는 1부터 N까지의 번호가 각각 하나씩 부여되어 있습니다. 
 * 각 마을은 양방향으로 통행할 수 있는 도로로 연결되어 있는데, 
 * 서로 다른 마을 간에 이동할 때는 이 도로를 지나야 합니다. 
 * 도로를 지날 때 걸리는 시간은 도로별로 다릅니다. 
 * 현재 1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고 합니다. 
 * 각 마을로부터 음식 주문을 받으려고 하는데, 
 * N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 합니다. 
 * 
 * 마을의 개수 N, 
 * 각 마을을 연결하는 도로의 정보 road, 
 * 음식 배달이 가능한 시간 K가 매개변수로 주어질 때,
 *  음식 주문을 받을 수 있는 마을의 개수를 return 하도록 solution 함수를 완성해주세요.
 *  
 *  마을의 개수 N은 1 이상 50 이하의 자연수입니다.
 *  road의 길이(도로 정보의 개수)는 1 이상 2,000 이하입니다.
 *  road의 각 원소는 마을을 연결하고 있는 각 도로의 정보를 나타냅니다.
 *  road는 길이가 3인 배열이며, 순서대로 (a, b, c)를 나타냅니다.
 *  a, b(1 ≤ a, b ≤ N, a != b)는 도로가 연결하는 두 마을의 번호이며, c(1 ≤ c ≤ 10,000, c는 자연수)는 도로를 지나는데 걸리는 시간입니다.
 *  두 마을 a, b를 연결하는 도로는 여러 개가 있을 수 있습니다.
 *  한 도로의 정보가 여러 번 중복해서 주어지지 않습니다.
 *  K는 음식 배달이 가능한 시간을 나타내며, 1 이상 500,000 이하입니다.
 *  임의의 두 마을간에 항상 이동 가능한 경로가 존재합니다.
 *  1번 마을에 있는 음식점이 K 이하의 시간에 배달이 가능한 마을의 개수를 return 하면 됩니다.

 */
public class Delivery {
	public static void main(String[] args) {
		int N = 4;
		int[][] road = {{1, 2, 2}, {1, 3, 10}, {2, 4, 2}, {3, 4, 1}};
		int K = 3;
		System.out.println(new Delivery().dijkstraSolution(N, road, K));
				
	}
	//fluid 알고리즘 전체 경로를 최적화 검색
	public int fluidSolution(int N, int[][] road, int K) {
		//도로 정보 갱신
		int[][] map = new int[N][N];
		int to;
		int from;
		for(int[] info : road) {
			to = info[0]-1;
			from = info[1]-1;
			
			if(map[from][to] == 0 || map[from][to] > info[2])
				setMap(map, from, to, info[2]);
		}
		
		//via로 모든 길을 우회해서 계산해봄
		int calcV;
		for(int via = 0; via < N; via++) {
			for(int start = 0; start < N; start++) {
				if(via == start || map[start][via] == 0)
					continue;
				
				for(int end = 0; end < N; end++) {
					if(via == end || start == end || map[via][end] == 0)
						continue;
				
					calcV = map[start][via] + map[via][end];
					if(map[start][end] == 0 || calcV < map[start][end]) {
						setMap(map, start, end, calcV);
					}
				}
			}
		}
		
		
		int answer = 1;
		for(int i = 1; i < N; i++) {
			if(map[0][i] != 0 && map[0][i] <= K)
				answer++;
		}
		return answer;
	}
	public int dijkstraSolution(int N, int[][] road, int K) {
		//map에 할당
		int[][] map = new int[N][N];
		int to;
		int from;
		for(int[] info : road) {
			to = info[0]-1;
			from = info[1]-1;
			
			if(map[from][to] == 0 || map[from][to] > info[2])
				setMap(map, from, to, info[2]);
		}
		
		
		Set<Integer> set = new HashSet<Integer>();
		int next = 0;	//다음 방문할 지점
		int min = Integer.MAX_VALUE; //next 선택을 위해서
		set.add(0);
		//첫번째로 우회해갈 마을 탐색
		for(int i = 1; i < N; i++) {
			if(map[0][i] != 0 && map[0][i] < min) {
				next = i;
				min = map[0][i];
			}
		}
		set.add(next);
		
		//next지점을 들려서 우회하기
		int calcV;	//갱신 가능한지 판단
		int nextCandidate = 0;
		while(set.size() != N) {
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				if(set.contains(i))	//이미 최소 값이 구해진 지점
					continue;
				
				//연결된 길이 있음
				if(map[next][i] != 0) {
					calcV = map[0][next] + map[next][i];
					//더 빠른지 판단
					if(map[0][i] == 0 || map[0][i] > calcV) {
						setMap(map, 0, i, calcV);
					}
				}
				//다음 방문지점인가?
				if(map[0][i] != 0 && min > map[0][i]) {
					nextCandidate = i;
					min = map[0][i];
				}
			}
			next = nextCandidate;
			set.add(next);
		}
		
		int answer = 1;
		for(int i = 1; i < N; i++) {
			if(map[0][i] != 0 && map[0][i] <= K)
				answer++;
		}
		return answer;
	}
	public static void setMap(int[][] map, int from, int to, int v) {
		map[from][to] = v;
		map[to][from] = v;
	}
}
