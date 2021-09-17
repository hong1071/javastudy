package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> q = new LinkedList<>();
		
		q.offer("마이콜");		//큐에 넣기
		q.offer("둘리");
		q.offer("도우너");		

		while(!q.isEmpty()) {
			String s = q.poll();		//큐에서 빼내기
			System.out.println(s);
		}
		
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("도우너");
		
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.poll());
		
		//비어있는경우 null을 반환함
		System.out.println(q.poll());
	}

}
