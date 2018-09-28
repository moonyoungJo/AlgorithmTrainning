package programmers.level1;

/*
 * 체육복
 * 
 * 오늘은 체육수업이 있는 날입니다. 
 * 그런데 점심시간에 도둑이 들어 몇몇 학생의 체육복이 도난을 당했습니다. 
 * 다행히 일부 학생들이 여벌의 체육복을 가져왔습니다. 
 * 학생들의 번호는 체격 순으로 매겨져 있기 때문에 바로 앞번호의 학생이나 
 * 바로 뒷번호의 학생에게만 체육복을 빌려주려고 합니다.
 * 
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
 * 당연히 체육복을 2벌 가져온 학생의 체육복이 도난을 당했다면, 
 * 여벌의 체육복을 빌려줄 수 없습니다.
 * 체육복이 없으면 체육수업을 들을 수 없기 때문에 체육복을 적절히 
 * 빌려 최대한 많은 학생이 체육수업을 듣고 싶습니다.
 * 
 * 전체 학생의 수 n, 
 * 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
 * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 */
public class GymClothes {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 3, 4};
		int[] reserve = {3, 4, 5};
		System.out.println(new GymClothes().solution(n, lost, reserve));
	}
	public int solution(int n, int[] lost, int[] reserve) {
		//lost, reserve를 배열로
		boolean[] hasNotOwn = new boolean[n+1];
		boolean[] reserveInfo = new boolean[n+1];
		for(int p : lost)
			hasNotOwn[p] = true;
		for(int i : reserve)
			reserveInfo[i] = true;
		
		int lastP = 0;	//옷 빌려간 마지막 사람
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
        	//도난당하지 않은 사람
        	if(!hasNotOwn[i]) {
        		answer++;
        		
        		//여벌옷이 있음
        		if(reserveInfo[i]) {	
        			
        			//유효한 사람이고 도난당하고 옷을 빌리지 못한 사람
        			if(i-1 >= 1 && hasNotOwn[i-1] && lastP != i-1) {//left
        				answer++;
        			}else if(i+1 <= n && hasNotOwn[i+1] && !reserveInfo[i+1]) {//right
        				//유효한 사람이고 도난당하고 여벌옷이 없는 사람
        				answer++;
        				lastP = i+1;
        			}     			
        		}
        	}else if(reserveInfo[i]) {
        		//도난당했으나 여벌옷을 가져온 사람
        		answer++;
        		lastP = i;
        	}
        }
        
        return answer;
    }
}
