package programmers.level3;

import java.util.HashMap;
import java.util.Iterator;

/*
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 
 * 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 
 * 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 * 
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 
 * 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 스파이가 가진 의상의 수는 0개 이상 30개 이하입니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 */
public class Camouflage {
	public static void main(String[] args) {
		String[][] arr = {{"yellow_hat", "headgear"},
				{"blue_hat", "headgear"},
				{"green_hat", "headgear"},
				{"balck_hat", "headgear"},
				{"red_hat", "a"},
				{"yellow_hat", "a"},
				{"red_hat", "b"},
				{"green_hat", "b"},
				{"yellow_hat", "c"},};
		System.out.println(new Camouflage().solution(arr));
	}
	public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();
		
		//분류
		for(String[] c : clothes) {
			if(map.containsKey(c[1])) {
				int tmp = map.get(c[1]);
				tmp++;
				map.put(c[1], tmp);
			}else
				map.put(c[1], 1);
		}
		
		//int[] 로 변경 - 옷의 종류별로 몇개 가지고 있는지
		int[] info = new int[map.size()];
		Iterator<String> iter = map.keySet().iterator();
		int index = 0;
		while(iter.hasNext()) {
			info[index] = map.get(iter.next());
			index++;
		}
		
		//계산
		int ret = 0;
		for(int i = 1; i <= info.length; i++) {
			int tmp = getCaseN(info, 0, i, 1);
			ret += tmp;
		}
		
		return ret;
	}
	
	//start 위치부터 n개의 옷 종류를 골라서 될 수 있는 경우의수 구하기
	private int getCaseN(int[] info, int start, int n, int total) {
		if(n == 0) {
			return total;
		}
		
		int ret = 0;
		for(int i = start; i + n <= info.length; i++) {
			ret += getCaseN(info, i+1, n-1, total*info[i]);
		}
		
		return ret;
	}
}
