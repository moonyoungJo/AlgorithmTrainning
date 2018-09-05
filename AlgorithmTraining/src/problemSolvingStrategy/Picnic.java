package problemSolvingStrategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * 안드로메다 유치원 익스프레스반에서는 다음 주에 율동공원으로 소풍을 갑니다. 
 * 원석 선생님은 소풍 때 학생들을 두 명씩 짝을 지어 행동하게 하려고 합니다. 
 * 그런데 서로 친구가 아닌 학생들끼리 짝을 지어 주면 서로 싸우거나 같이 돌아다니지 않기 때문에, 
 * 항상 서로 친구인 학생들끼리만 짝을 지어 줘야 합니다.각 학생들의 쌍에 대해 이들이 서로 친구인지 여부가 주어질 때, 
 * 학생들을 짝지어줄 수 있는 방법의 수를 계산하는 프로그램을 작성하세요. 
 * 짝이 되는 학생들이 일부만 다르더라도 다른 방법이라고 봅니다. 
 * 예를 들어 다음 두 가지 방법은 서로 다른 방법입니다.
 * 
 * (태연,제시카) (써니,티파니) (효연,유리)
 * (태연,제시카) (써니,유리) (효연,티파니)
 */
public class Picnic {
	public static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseN = sc.nextInt();
		
		for(int i = 0; i < caseN; i++) {
			int studentN = sc.nextInt();
			int friendN = sc.nextInt();
			
			FriendDAO friendDao = new FriendDAO();
			
			for(int j = 0; j < friendN; j++) {
				friendDao.addFriend(sc.nextInt(), sc.nextInt());
			}
			System.out.println(calculate(friendDao, studentN));
		}
		
	}
	public static int calculate(FriendDAO friendDao, int studentN) {
		result = 0;
		LinkedList<Integer> restStudent = new LinkedList<>();
		for(int i = 0; i < studentN; i++)
			restStudent.add(i);
		subCalculate(friendDao, restStudent);
		return result;
	}
	//첫번째 친구와 나머지 친구들을 한번씩 짝지어보고 가능한 경우의 수를 제귀적으로 계산
	public static void subCalculate(FriendDAO friendDao, LinkedList<Integer> restStudent) {
		if(restStudent.isEmpty()) {
			result++;
			return;
		}
		
		int f1 = restStudent.poll();
		int f2;
		for(int i = 0; i < restStudent.size(); i++) {
			f2 = restStudent.remove(i);
			if(friendDao.isFriend(f1, f2)) {				
				subCalculate(friendDao, restStudent);				
			}
			restStudent.add(i, f2);
		}
		
		restStudent.push(f1);
	}
	
}
//friend 정보를 관리하는 object
class FriendDAO{
	HashMap<Integer, TreeSet<Integer>> friendsMap = new HashMap<>();
	
	public void addFriend(int f1, int f2) {
		if(f1 > f2) {
			int tmp = f1;
			f1 = f2;
			f2 = tmp;
		}
		if(friendsMap.containsKey(f1)) {
			friendsMap.get(f1).add(f2);
		}else {
			TreeSet<Integer> set = new TreeSet<>();
			set.add(f2);
			friendsMap.put(f1, set);
		}
	}
	public boolean isFriend(int f1, int f2) {
		if(f1 > f2) {
			int tmp = f1;
			f1 = f2;
			f2 = tmp;
		}
		
		if(friendsMap.containsKey(f1) && friendsMap.get(f1).contains(f2)) {
			return true;
		}
		return false;
	}
}
