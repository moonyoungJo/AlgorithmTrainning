package problemSolvingStrategy;

import java.util.Scanner;

/*
 * Ŀ�ٶ� �������� ������ �� �佺Ƽ���� �����Ϸ��� �մϴ�. 
 * �� �佺Ƽ���� ���� �� ���� ����Ǹ�, 
 * �Ϸ翡 �� ���� ��尡 �����忡�� �ܼ�Ʈ�� �ϰ� �˴ϴ�. 
 * ��ü ��带 �� �� ������ ���� ���� �������� �ʾ�����, 
 * �佺Ƽ���� ���� ��Ÿ�� L���� ���� �̹� ���ܰ� ���� �����Դϴ�. 
 * 
 * ���� �佺Ƽ���� �ּ� L�� �̻� �����ϰ� �˴ϴ�.
 * �̹��� ����� �������� �Ϸ� ������ �� ��� ����� ���� ���� �ٸ��ϴ�. 
 * ������ ���� ������ �� ���ؼ� ������ �뿩 ����� ���̷��� �մϴ�. 
 * ������ N�ϰ��� ������ �뿩 ����� �˰� �ִٰ� �սô�. 
 * �� �� L�� �̻��� �����ؼ� �뿩�ϵ�, �������� �Ϸ� ������ �� ��� 
 * ��� ����� �ּ�ȭ�Ϸ��� ��� �������� ������ �ұ��?
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
	public static double calculate(int dayN, int atLeast, int[] dayInfo) {
		double min = Double.MAX_VALUE;
		double value = 0;
		for(int day = atLeast; day <= dayN; day++) {
			for(int start = 0; start + day <= dayN; start++) {
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
