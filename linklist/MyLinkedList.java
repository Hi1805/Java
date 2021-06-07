package linklist;

import java.util.LinkedList;
import java.util.Scanner;









/*
In ra gia tri node ke cuoi
Tong cac gia tri trong danh sach lien ket
Dem trong danh sach lien ket bao nhieu so chan
Tinh trung binh cong cac song nguyen to trong danh sach lien ket 
dao 2 node cuoi cho nhau 
dao 2 node dau 
dao node dau va node cuoi 
dao nguoc danh sach lien ket 

*/
public class MyLinkedList<E> {
	private class Node{
		private E info;
		private Node next;
		public Node(E element) {
			info = element;
			this.next = null;
		}
		public Node (E element,Node next) {
			this.info = element;
			this.next = next;
		}	
		public String toString() {
			return "Node : infor ="+info +","+"Next = "+next;
		}
	}
	private int size ;
	private Node headNode;
	private Node tailNode;
	
	public MyLinkedList () {
		headNode = null;
		tailNode  = null;
		size = 0;
	}
	
	public MyLinkedList(Node heNode, Node telNode, int size) {
		this.headNode = heNode;
		this.tailNode = telNode;
		this.size = size;
	}
	
	
	public void addLast(E element) {
		 Node p = new Node(element);
		if(size == 0) { // 
			headNode = p;
			tailNode = p;
		}
		else {
			tailNode.next = p;
			tailNode = p;
		}
		
		size++;	
	}
	public void addFisrt(E element) {
		 Node p = new Node(element);
		if(size == 0) { // 
			headNode = p;
			tailNode = p;
		}
		else {
			 p.next = headNode;
			headNode = p;
		}
		
		size++;	
	}
	public void add(Node E) {
			E.next = null;
			if(size == 0) { // 
				headNode = E;			}
			else {
				tailNode.next = E;		
			}
			tailNode = E;
			size++;
	}
	public String  toString() {
		Node q = headNode;
		String s ="";
		while (q!= null) {
			s += q.info+" ";
			q = q.next;	
		}
		return s;
	}
	
	public String toString1() {
		Node q = headNode;
		String s ="";
		for (int i = 0; i < size; i++) {
			s += q.info+" ";
			q=q.next;
		}
		return s;
	}
	
	public E nextEnd () { // lay gia tri ke cuoi
		Node q = headNode;
		if(q.next ==null) {
			return null;
		}
		while(q.next.next !=null) { // kiem tra xem next ke tiep co bang null hay khong
			q = q.next;// gan node bang node tiep theo
		}
		return q.info;
	}
	
	//Lay Node ke cuoi
	public Node nextEndNode() { // lay gia tri ke cuoi
		Node q = headNode;
		if(q.next ==null) {
			return null;
		}
		while(q.next.next !=null) { // kiem tra xem next ke tiep co bang null hay khong
			q = q.next;// gan node bang node tiep theo
		}
		return q;
	}

	public E get(int index) {
		if(index <0 ||index > size) {
			return null;
		}
	
			Node qNode = headNode;
			int i = 1;
			while( i<= index) {
				qNode = qNode.next;
				i++;
			}
			return qNode.info;
		
	}
//	public void set(E e, int index) {
//		if(index <0 ||index > size) {
//			return ;
//		}
//	
//			else {
//				Node q = headNode;
//				int i = 1;
//				while (i<=index) {
//					q = q.next;
//				}
//				q.info = e;
//			}
//		}
//		
	public void add(E e ,int index ) {
		if(index <0 ||index > size) {
			return ;
		}
		if(index == 0 ) {
			addFisrt(e);
		}
		else {
			if(index == size ) {
				addLast(e);
			}
			else {
				Node q = headNode;
				Node r = null;
				for (int i = 0; i <index; i++) {
					r = q;
					q = q.next;
				}
				Node p = new Node(e, q);
				r.next = p;
			}
	}
	}
	public int sum() {// tong cac gia tri
		Node q = headNode;
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum+=(int)q.info;
			q=q.next;
		}
		return sum;
	}
	
	
	public int  countEven() {//dem trong danh sach lien ket co bao nhieu so chan
		int count = 0;
		Node qNode = headNode;
		for (int i = 0; i < size; i++) {
			if((int)qNode.info % 2 ==0) {
				count++;
			}
			qNode = qNode.next;
		}
		return count;
	}
	
	
	public boolean isPrime(int x) {
		if(x<2)
			return false;
		
		
		for (int i = 2; i <Math.sqrt(x); i++) {
			if(x%2==0)
				return false;
		}
		return true;
	}
	public  double sumIsPrime() {// tinh trung binh cac so nguyen to
		int count = 0;
		int sum = 0;
		Node qNode = headNode;
		for (int i = 0; i < size; i++) {
			if (isPrime((int)qNode.info)) {
				count++;
				sum+=(int)qNode.info;
			}
		}
		if(count == 0)
			return 0;
		return 1.0*sum/count;
	}
	
	public void reverseFinal() { // dao 2 node cuoi
		Node q = headNode;
		while(q.next.next.next !=null) { // lay node ke  cua ke cuoi
			q = q.next;// gan node bang node tiep theo
		}
		
		Node q2 = q.next;// node ke cuoi 
		
		//doi dia chi node ke cuoi va tail
		Node tempNode = tailNode;
		tailNode = q2;
		q2 = tempNode;
		
		
		System.out.println("====================");
		
		//bien next tail node bang null 
		tailNode.next = null;
		q2.next = tailNode;
		
		// gan next ke cua ke cuoi thanh dia chi cua q2
		q.next = q2;
		
		System.out.println("q  da doi = "+ nextEndNode());
		System.out.println("tail da doi = "+tailNode);
	}	
	
	public void  reverseStart() {
		if(headNode.next.next == null) {
			tailNode = headNode;
		}
		
		Node temp1=this.headNode;     // lay dia chi cua head   
		Node temp2=this.headNode.next; // lay dia chi cua ke tiep cua head
		Node temp3 = this.headNode.next.next;// lay dia chi con cua node ke tiep
		
		
		headNode = temp2;
		headNode.next = temp1;
		headNode.next.next = temp3;
		
		
		
		System.out.println(headNode);
		System.out.println(tailNode);
		
	
	}
	public void reverseStartAndEnd() {
		Node qNode = headNode;
		Node qNode2 = tailNode;
		Node tempNode1 = headNode.next;// node thu 2
		Node tempNode2 = nextEndNode();// node ke cuoi 
		
		headNode = qNode2;
		tailNode = qNode;
		
		headNode.next = tempNode1;
		tempNode2.next = tailNode;
		tailNode.next = null;
		
	}
	
	public void removeNegative() { // xoa so am
		while (headNode !=null &&(int)headNode.info < 0) {
			headNode = headNode.next;	
		}
		if(headNode == null)
			return;
		Node r = headNode;
		Node q = headNode.next;
		while (q != null) {
			if((int)q.info < 0) {
				r.next  = q;
				r = r.next;
			}
			q = q.next;
		}
		
			r.next = null;
			tailNode  = r;
	}
	public void reverse() { // dao nguoc danh sach lien ket
		Node qNode = headNode;
		tailNode = qNode;
		Node temp1 = null;
		Node temp2 = null;
		while(qNode !=null) {
			temp1 = qNode;
			qNode = qNode.next;
			temp1.next = temp2;
			temp2 = temp1;		
		}
		headNode = temp1;
		System.out.println(tailNode);
	}
	// cach 2
	public void reverse2() {
		tailNode  = headNode;
		Node head1 = null;
		
		while (headNode !=null) {
			Node qNode = headNode;
			headNode = headNode.next;
			qNode.next = head1;
			head1 =qNode;
		}
		headNode = head1;
	}

	public void removeFirst() {
		headNode = headNode.next;
	}
	public void removeLast() {
		Node q = headNode;
		while (q.next != tailNode) {
			q = q.next;	
		}
		tailNode = q;
		tailNode.next = null;
	}
	public void remove(int index) {
		if (index >= size || index <0 ) {
			System.out.println("index not invalid");
			return;
		}
		if (index == 0) {
			removeFirst();
		}
		if(index == size - 1) {
			removeLast();
		}
		else {
			Node qNode = headNode;
			for (int i = 0; i < index-1; i++) {
				 qNode = qNode.next;
			}
			qNode.next = qNode.next.next;
		
		}
	}
	
	public void removeDuplicate() { // xoa so trung 
		Node qNode = headNode;
		
		for (int i = 0 ; qNode!= null ; qNode = qNode.next) {
			Node q2  = qNode.next;
			for (int j = i+1; q2 != null; q2 = q2.next) {
				if(q2.info == qNode.info)
					remove(j);
				else
					j++;
			}
			i++;
		}
	}
	public void  removeElement (Node element ) { // element = q2
		if(headNode == element)
			headNode = headNode.next;
		else {
			Node qNode = headNode;
			while (qNode.next != element) {
				qNode = qNode.next;	
			}
			
			qNode.next = qNode.next.next;
		}
	}
	public int size() {
		return size;
	}
	public void removeDuplicate2() { // xoa so trung 
		
		Node q = headNode;//4
		while (q!=null) {
			Node q2 = q.next;	
			Node r = q;				//    q
			while (q2!=null) {  	//	         r  q2
				if(q2.info == q.info) {// 2	 1  10 20  2 1     3 
					r.next = q2.next;
				}
				else	r = r.next;
					
				q2 = q2.next;	
			}
			q=q.next;
		}
	}
	
	// Tach danh sach lien ket  thanh 2 :< 1 : chan , 1 le >
	public void splitListEvenAndOdd () {
		MyLinkedList<E> headEven = new MyLinkedList<>();
		MyLinkedList<E> headOdd  = new MyLinkedList<E>();
		
		while ( headNode != null) {
			Node qNode = headNode;
			headNode = headNode.next;
			if((int)qNode.info % 2 == 0) {
				headEven.add(qNode);
			}
			else {
				headOdd.add(qNode);
			}
			
		}
			MyLinkedList<E> temp = headEven;
			if(temp.headNode == null) {
				temp  = headOdd;
			}
			temp.tailNode = null;
			System.out.println("Chan "+headEven);
			System.out.println("le "+headOdd);
	}
	MyLinkedList<E> linkedListSortFrom( MyLinkedList<E> l2){ // gop 2 mang tang dan
		MyLinkedList<E> l3 = new MyLinkedList<E>();
		while (this.headNode != null && l2.headNode !=null ) {
			Node q;
			if((int)this.headNode.info > (int) l2.headNode.info ) {
				q = l2.headNode;
				l2.headNode = l2.headNode.next;
			}
			else {
				 q = this.headNode;
				this.headNode = this.headNode.next;
			}
			l3.add(q);
		}
		Node temp = this.headNode;
		Node tail = this.tailNode;
		if(temp == null) {
			temp = l2.headNode;
			tail = l2.tailNode;
		}
		l3.tailNode.next = temp;
		l3.tailNode = tail;
		return l3;
	}
	MyLinkedList<Integer>  convert(String s) {// string to LinkedList
		int y = 3;
		MyLinkedList<Integer> list = new MyLinkedList<>();
		for (int i =  s.length()-1; i >=0 ; i--) {
				list.addLast((int)(s.charAt(i)-48));
		}
		return list;
	}
	public String sumBigNumbers(String s1 , String s2) {
		String sum ="";
		int length1 = s1.length()-1;
		int length2 = s2.length()-1;
		
		MyLinkedList<Integer> list1 = new MyLinkedList<>();
		MyLinkedList<Integer> list2 = new MyLinkedList<>();
		MyLinkedList<Integer> list3 = new MyLinkedList<>();
		
		MyLinkedList<Integer> temp = list1;
		if(length1 > length2) {
			temp = list2;
		}
		
		while (length1 >=0  ||  length2 >= 0) {
			if(length1 < 0 || length2 <0 ) {
				temp.addLast((int)(0));
			}
			else {
				temp.addLast((int)(s1.charAt(length1)-48));
				temp.addLast((int)(s2.charAt(length2)-48));
			}
			
			length1 --;
			length2 --;
		}
		
		MyLinkedList<Integer>.Node head1 = list1.headNode;
		MyLinkedList<Integer>.Node head2 = list2.headNode;
		
		int extra = 0;
		int temp2 = 0;
		while (head1 != null && head2 != null) {
			temp2 = head1.info + head2.info + extra;
			sum  = (temp2%10) + sum ;
			extra = temp2/10;
			head1 = head1.next;
			head2 = head2.next;
		}
		if(extra > 0 ) {
			sum  =  extra + sum ;
		}
		return sum ;
	}

	public void sortA() {
		int length = size;
		Node q = headNode;
	 	Node r = headNode.next;
		for(int i = 0 ; i< length - 1 ; i++ ) {
			 for (int j = 0; j < length-i-1; j++){
				 	
		            if ((int)q.info > (int)r.info){
		            	
		            }
		        }
		}
		
	}
	// kiem tra co node nào chứa E
			public boolean contain(E x) {
				Node q = headNode;
				for(int i = 0 ; i < size ; i++) {
					if( q.info == x)
						return true;
					q = q.next;
				}
				return false;
			}
		// 
			public int indexOf(E x) {
				Node q = headNode;
				for(int i = 0 ; i < size ; i++) {
					if( q.info == x)
						return i;
					q = q.next;
				}
				return -1;
			}

			
			public int lastIndexOf(E x) {
				int index = -1;
				Node q = headNode;
				for(int i = 0 ; i < size ; i++) {
					if( q.info == x)
						index = i;
					q = q.next;
				}
				return index;
			}
	public void instert(E x) { // chen vao mang tang dan
		Node q = null;
		Node p = new Node(x);
		if((int) headNode.info > (int)p.info) {
			p.next = headNode;
			headNode = p;
		}
		for ( Node q1 = headNode;  q1!=null; q1= q1.next) {
			if((int) headNode.info > (int)p.info) {
				p.next = headNode;
				headNode = p;
			}
		}
	
	}
	public static void main(String agrs[]) {
		
		/// LinkedList  gia lap 
		MyLinkedList<Integer> list  = new MyLinkedList<Integer>();
		list.addLast(5);
		list.addLast(7);
		list.addLast(8);
		list.addLast(11);
		System.out.println(list);
		list.instert(3);;
		System.out.println(list);
//		list.add(10, 3);
//		list.removeFirst();
//		list.removeLast();
//		System.out.println(list);
	//	System.out.println(list.get(2));
	//	System.out.println("get index" +list.get(0));
//		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
//		list2.add(1);
//		list2.add(2);
//		list2.add(10);
//		list2.add(12);
//		list2.add(15);
//		
		
		//System.out.println("so ke cuoi = "+list.nextEnd());
		//System.out.println(list.get(3));
		//System.out.println("tong = "+list.sum());
//		System.out.println("So luong so chan = "+list.countEven());
//		list.reverseFinal();
		//System.out.println("Da chay khi dao nguoc 2 node cuoi \n  "+list);
		//list.reverseStart();
////		System.out.println("Dao nguoc 2 node dau \n "+list);
//		
//		list.reverse();
	//	list.reverseStartAndEnd();
	//	list.remove(1);
	//	list.removeElement(list.headNode.next);
//		list.removeDuplicate2();
//		System.out.println(list);
//		list.removeNegative();
//		System.out.println(list);
//		System.out.println(list);
//		
//		list.splitListEvenAndOdd();
		//System.out.println(list.linkedListSortFrom(list2));
		
		
//		String s1 = (new Scanner(System.in).nextLine());
//		String s2 =  (new Scanner(System.in).nextLine());
//		System.out.println(	list.sumBigNumbers(s1, s2));
		
		
		// linkedList co san
//		System.out.println("Cua linkedList co san");
//		LinkedList<Integer> list3 = new LinkedList<Integer>();
//		list2.add(10);
//		list2.add(100);
//		list2.add(5);
//		list2.add(5);
		

////		System.out.println(list2);
//		System.out.println(list2.getFirst());
		
	}
}
