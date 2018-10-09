package digitalCoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * 숫자들의 배열이 한 줄에 주어지고
 * 이 숫자들 중 3개를 골라 만들어야 할 수가 다음 줄에 주어진다.
 * 
 * 3개를 골라 특정 값을 만드는 경우를 찾아서 오름차순으로 출력하라
 * 만약 같은 수가 중복된다면 (1 1 2와 2 1 1의 경우처럼) 하나만 출력해야 한다.
 * 그리고 각 경우에 대해서도 오름차순으로 정렬후에 출력한다.
 */
public class SelectThreeGame {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		ArrayList<Integer> arr = new ArrayList<>();

		//숫자조각들
		while (st.hasMoreTokens()) {
			arr.add(Integer.parseInt(st.nextToken()));
		}

		//만들어야 할 수
		input = br.readLine();
		SortedSet<String> set = new TreeSet<>();
		select(arr, 0, 3, Integer.parseInt(input), new LinkedList<Integer>(), set);

		if (set.size() == 0) {
			System.out.println("NO");
			return;
		}
		for (String s : set) {
			System.out.println(s);
		}

	}

	//arr이 주어졌을 때 start부터 rest개를 골라 restV를 만들기.
	public static void select(ArrayList<Integer> arr, int start, int rest, int restV, LinkedList<Integer> cur,
			SortedSet<String> result) {
		if (rest == 0) {
			if (restV != 0)	//잘못된 경우
				return;

			//올바른 경우
			Collections.sort(cur);
			StringBuilder sb = new StringBuilder("");
			for (int c : cur) {
				sb.append(c + " ");
			}
			result.add(sb.substring(0, sb.length() - 1).toString());
			return;
		}
		
		//start위치의 값을 추가할 경우
		if (restV >= arr.get(start)) {
			cur.add(arr.get(start));
			select(arr, start + 1, rest - 1, restV - arr.get(start), cur, result);
			cur.remove(arr.get(start));
		}

		//start위치의 값을 추가하지 않을 경우
		if (start + rest < arr.size()) {
			select(arr, start + 1, rest, restV, cur, result);
		}
	}
}
