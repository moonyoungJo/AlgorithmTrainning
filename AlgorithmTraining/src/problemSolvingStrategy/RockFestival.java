package problemSolvingStrategy;

import java.util.Scanner;

/*
 * 커다란 공연장을 빌려서 록 페스티벌을 개최하려고 합니다. 
 * 이 페스티벌은 여러 날 동안 진행되며, 
 * 하루에 한 팀의 밴드가 공연장에서 콘서트를 하게 됩니다. 
 * 전체 밴드를 몇 팀 섭외할 지는 아직 결정하지 않았지만, 
 * 페스티벌의 간판 스타인 L개의 팀은 이미 섭외가 끝난 상태입니다. 
 * 
 * 따라서 페스티벌은 최소 L일 이상 진행하게 됩니다.
 * 이번에 사용할 공연장은 하루 빌리는 데 드는 비용이 매일 매일 다릅니다. 
 * 때문에 공연 일정을 잘 정해서 공연장 대여 비용을 줄이려고 합니다. 
 * 앞으로 N일간의 공연장 대여 비용을 알고 있다고 합시다. 
 * 이 중 L일 이상을 연속해서 대여하되, 공연장을 하루 빌리는 데 드는 
 * 평균 비용을 최소화하려면 어떻게 공연장을 빌려야 할까요?
 */
public class RockFestival {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();
		
		for(int i = 0; i < caseNum; i++) {
			int dayN = sc.nextInt();
			int atLeast = sc.nextInt();
			int dayInfo[] = new int[dayN];
			
			for(int j = 0; j < dayN; j++) {
				dayInfo[j] = sc.nextInt();
			}
			
			System.out.println(calculate(dayN, atLeast, dayInfo));
		}
	}
	//모든 경우에 대해 계산
	public static double calculate(int dayN, int atLeast, int[] dayInfo) {
		double min = Double.MAX_VALUE;
		double value = 0;
		for(int day = atLeast; day <= dayN; day++) {	//몇일을 공연할지
			for(int start = 0; start + day <= dayN; start++) {	//언제부터 할 지
				value = subCalc(dayInfo, start, start + day - 1);
				if(min > value)
					min = value;
			}
		}
		return min;
	}
	private static double subCalc(int[] dayInfo, int start, int end) {
		double ret = 0;
		for(int i = start; i <= end; i++) {
			ret += dayInfo[i];
		}
		return (ret / (end - start + 1));
	}
}
