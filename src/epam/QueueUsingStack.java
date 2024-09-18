package epam;

import java.util.Stack;

public class QueueUsingStack {
	
	Stack<Integer> s1= new Stack<Integer>();
	Stack<Integer> s2= new Stack<Integer>();
	
	public void enqueue(int val) {
		s1.push(val);
	}
	
	public int dequeue() {
		if (s2.size()!= 0) {
			return s2.pop();
		}
		
		if (s1.empty()) {
			return -1;
		}
		
		while(s1.size()!=0) {
			s2.push(s1.pop());
		}
		return s2.pop();
	}
	
	
	public static void main(String[] args) {
		QueueUsingStack queue= new QueueUsingStack();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		queue.enqueue(6);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
