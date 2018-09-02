package programmers.mockTest;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * OO 조선소에서는 태풍으로 인한 작업지연으로 수주한 선박들을 기한 내에 완성하지 못할 것이 예상됩니다.
 * 기한 내에 완성하지 못하면 손해 배상을 해야 하므로 남은 일의 작업량을 숫자로 매기고 배상비용을 최소화하는 
 * 방법을 찾으려고 합니다.
 * 배상 비용은 각 선박의 완성까지 남은 일의 작업량을 제곱하여 모두 더한 값이 됩니다.
 * 조선소에서는 1시간 동안 남은 일 중 하나를 골라 작업량 1만큼 처리할 수 있습니다. 
 * 조선소에서 작업할 수 있는 N 시간과 각 일에 대한 작업량이 담긴 배열(works)이 있을 때 배상 비용을 
 * 최소화한 결과를 반환하는 함수를 만들어 주세요. 
 * 
 * 예를 들어, N=4일 때, 선박별로 남은 일의 작업량이 works = [4, 3, 3]이라면 
 * 배상 비용을 최소화하기 위해 일을 한 결과는 [2, 2, 2]가 되고 
 * 배상 비용은 22 + 22 + 22 = 12가 되어 12를 반환해 줍니다.
 */
public class Problem2 {
	public int solution(int no, int[] works) {
		//남은 작업량이 많은 순으로 소팅된 상태를 유지하는 큐
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int w : works) {
			priorityQueue.add(w);
		}
		
		//큐에서 하나씩 빼와서 일을 함
		for (int i = 0; i < no && !priorityQueue.isEmpty(); i++) {
			int w = priorityQueue.poll();
			w--;
			if (w != 0)
				priorityQueue.add(w);
		}
		
		//결과 계산
		int result = 0;
		for (int rest : priorityQueue) {
			result += (rest * rest);
		}

		return result;
	}
}
