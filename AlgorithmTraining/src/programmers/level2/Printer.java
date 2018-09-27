package programmers.level2;

import java.util.LinkedList;

/*
 * 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 
 * 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 
 * 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 
 * 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다
 * 
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 * 
 * 
 * 풀이 : 인쇄작업 순서대로 그대로 코드를 짜면 된다
 */
public class Printer {
	public static void main(String[] args) {
		int[] priorities = {2,2,2,1,3,4};
		int location = 1;
		System.out.println(new Printer().solution(priorities, location));
		
	}
	public int solution(int[] priorities, int location) {
		LinkedList<Item> queue = new LinkedList<Item>();
		int index = 0;
		for(int p : priorities) {
			queue.offer(new Item(p, index));
			index++;
		}
		
		int out = 1;
		Item item;
		while(!queue.isEmpty()) {
			//대기목록에서 가장 큰 수 찾기
			int maxIndex = 0;
			for(int i = 0; i < queue.size(); i++) {
				if(queue.get(maxIndex).priority < queue.get(i).priority)
					maxIndex = i;
			}
			
			//프린터 할 것 전의 작업들은 모두 뒤로 넣기
			for(int i = 0; i < maxIndex; i++) {
				queue.offer(queue.poll());
			}
			
			//출력
			item = queue.poll();
			if(item.index == location) {
				return out;
			}
			out++;
		}
		
		
		return -1;
	}
}
class Item{
	int priority;
	int index;
	Item(int priority, int index){
		this.priority = priority;
		this.index = index;
	}
}