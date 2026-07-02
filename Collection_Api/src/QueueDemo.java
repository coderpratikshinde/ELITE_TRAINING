import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		
		Queue<String> que = new LinkedList<String>();
		que.offer("Apple");
		que.offer("Banana");
		que.offer("Cherry");
		
		System.out.println(que.peek());
		
		while(!que.isEmpty()) {
			System.out.println(que.poll());
		}
		
		que.offer("Apple");
		que.offer("Banana");
		que.offer("Cherry");
		
		/*System.out.print(que.peek());
		que.remove();
		System.out.println(" Dequeued Sucessfully");
		System.out.println(que.peek());*/

		Deque<String> dq = new LinkedList<String>();
		dq.addAll(que);
		dq.addFirst("Apple");
		dq.addLast("Pineapple");
		
		while(!dq.isEmpty()) {
			System.out.println(dq.pop());
		}
	}

}
