package Exam;

import java.util.LinkedList;



public class Singly_LinkedList<E> {
	private static class Node<E>{
		private E info;
		private Node<E> next;
		public Node (E info,Node<E> next) {
			this.info = info;
			this.next = next;
		}
		public Node(E element) {
			info = element;
			this.next = null;
		}
		@Override
		public String toString() {
			return "Node [info=" + info + ", next=" + next + "]";
		}
		
	}
	private Node<E> head,tail;
	private int size;
	
	public Singly_LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	public void add(E element) {
		 Node p = new Node(element);
		if(size == 0) { // 
			head = p;
			tail = p;
		}
		else {
			tail.next = p;
			tail = p;
		}
		
		size++;
	
	}
	
	// nodeList 3 5 7 6 8     7 8 9 10
	public void add(Node q,  int index) { 
		if(index <0 || index > size)
			 return ;
		Node temp1 = q;
		int  length = 0;
		while(q.next != null) {  
			q = q.next;
			length ++;		
		}
		if(index == 0) {	
			q.next = head;
			head = temp1;	
		}
		else {
			if(index == size) {	// 10 20 
				tail.next = temp1;// temp1 = 15 9 
				tail = q;		// q = 9	=> tail = 9
			}
			else { 
				Node temp = head;
				for (int i = 0; i < index -1 ; i++) { 
					temp = temp.next;
				}
				Node temp2 = temp.next;
				temp.next = temp1;
				q.next = temp2;
						
			}
		}
		size = size + length+1;
	}
	public int  getSize() {
		return size;
	
	}
	 public Node<E> getTail() {
		return tail;
	}
	@Override
	public String toString() {
		String  s ="";
		Node q = head;
		while (q!=null) {
			s= s + (int)q.info+" ";
			q=q.next;	
		}
		return s;
	}
	public Node<E> remove(int index) {
		Node element = null;
		if (index >= size || index <0) {
			return element;
		}
		if (index == 0) {
			element = head;
			head = head.next;	
		}
		else {
			Node qNode = head;
			for (int i = 0; i < index-1; i++) {
				 qNode = qNode.next;
			}
			element = qNode.next;
			qNode.next = qNode.next.next;
		}
		return element;
	}

	public static void main( String agrs[]) {
		Node<Integer> q1= new Node<Integer>(9,null);
		
		Node<Integer> q2 = new Node<Integer>(15,q1);
		
		
		Node<Integer> q3 = new Node<Integer>(15,null);
		
		Singly_LinkedList<Integer> s1  = new Singly_LinkedList<Integer>();
		
		s1.add(10);
		s1.add(20);
		System.out.println(s1.getSize());
//		s1.add(q2, 1);
		System.out.println(s1.getSize());
		System.out.println(s1.getTail());
		System.out.println("them lan 1 : "+s1);
	//	s1.add(q3, 1);
		System.out.println(s1.getSize());
		System.out.println(s1.getTail());
		System.out.println("them lan 2: "+ s1);
		
		System.out.println(s1.remove(0));
		System.out.println("da xoa "+s1);
		
	}
}
