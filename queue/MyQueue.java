package queue;


public class MyQueue <E>{
	private class Node {
		private E info ;
		private Node next;
		
		public Node(E info) {
			this.info = info;
			next = null;
		}
		public Node( E infoE , Node nextNode ) {
			info = infoE;
			nextNode = nextNode;
		}
	}
	
	private Node head,tail;
	private int size;
	
	public MyQueue() {
		// TODO Auto-generated constructor stub
	}
	public boolean isEmpty() {
		return size  == 0;
	}
	public E peek() {
		if(size == 0 ) {
			System.out.println(" invalid");
			return null;
		}
		return head.info;
	}
	public E pop() {
		if(size == 0) {
			System.out.println("error");
			return null;
		}
			Node q = head;
			head = head.next;
			size -- ;
			return q.info;
	}
	public boolean push(E e ) {
		Node p = new Node(e);
		if(size == 0) {
			head = tail = p;
		}
		else {
			tail.next = p;
			tail = p;
		}
		size++;
		
		return true;
	}
	
	public String toString() {
		Node q = head;
		String s = "";
		while (q != null) {
			s = s + q.info+ " ";
			q = q.next;
		}
		return s;
	}
	
	public static void main(String agrs[]) {
		MyQueue<Integer> m1 = new MyQueue<Integer>();
		m1.push(10);
		m1.push(20);
		System.out.println(m1);
	}
}
