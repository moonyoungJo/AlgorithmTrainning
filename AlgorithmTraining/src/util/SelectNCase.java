package util;

import java.util.LinkedList;

public class SelectNCase {
	// d에서 start부터 n개의 수를 뽑는 경우를 구해서 result에 넣기
	public void select(int[] d, int start, int num, LinkedList<Integer> cur, LinkedList<LinkedList<Integer>> result) {
		if (num == 0) {
			LinkedList<Integer> list = new LinkedList<>();
			for (int i : cur) {
				list.add(i);
			}
			result.add(list);
			return;
		}

		cur.add(d[start]);
		select(d, start + 1, num - 1, cur, result);
		cur.removeLast();

		if (start + num < d.length) {
			select(d, start + 1, num, cur, result);
		}
	}
}
