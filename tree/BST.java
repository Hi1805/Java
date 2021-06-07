package tree;

import java.util.ArrayList;

// xoa 1 gia tri
// tong cac so nguyen to
public class BST<E> {
	private  class Node{
		private Comparable<E> info;
		private Node left, right;
		
		public Node(){
			
		}

		public Node(Comparable<E> info, BST<E>.Node left, BST<E>.Node right) {
			this.info = info;
			this.left = left;
			this.right = right;
		}
		public Node(Comparable<E> info) {
			this.left = null;
			this.right = null;
			this.info = info;
		}
	}
	
	private Node root = null;
	public BST() {
		
//		Node r8 = new Node((E)(Integer)4);
//		Node r3 = new Node((E)(Integer)9,null,r8);
//		Node r1 = new Node((E)(Integer)7,r3,new Node((E)(Integer)3));
//		Node r6 = new Node((E)(Integer)6,null,new Node((E)(Integer)20));
//		Node r5 = new Node((E)(Integer)5,new Node((E)(Integer)3),null);
//		Node r2 = new Node((E)(Integer)1,r5,r6);
//		root = new Node((E)(Integer)20,r1,r2);
			
	}
	private Node  add(Node r, Comparable<E> x) {
		
		if(r != null) {
			if(x.compareTo((E) r.info) < 0) {
				r.left = add(r.left, x);
			}
			else 
				if(x.compareTo((E) r.info) > 0) {
					r.right = add(r.right, x);
				}	
		}
		else
			r = new Node(x);
		return r;
	
		
	}
	public void add(Comparable<E> x) {
		root = add(root, x);
	}
	public void inOrder(Node r ) {//duyet phan tu
		if(r != null ) {
			System.out.print(r.info + " ");
			inOrder(r.left);
			inOrder(r.right);
		}
	}
	
	public void inOrder() {
		inOrder(root);
	}
	public void inOrder2(Node r) {//duyet trung tu
		inOrder2(r.left);
		System.out.print(r.info + " ");
		inOrder2(r.right);
	}
	public void inOrder2() {
		inOrder2(root);
	}
	public void inOrder3(Node r) {//duyet Hau tu
		inOrder3(r.left);
		inOrder3(r.right);
		System.out.print(r.info + " ");
	}
	public void inOrder3() {
		inOrder3(root);
	}
	private  boolean find(Node r, Comparable<E> x) {
		if(r == null )
			return false;
		if(x.compareTo((E) r.info )  < 0 ) {
			return find(r.left, x);
		}
		if(x.compareTo((E) r.info )  > 0 ) {
			return find(r.right, x);
		}
		return true;
	}
	public  E findMax() {
		if(root == null ) {
			return null;
		}
		Node q = root;
		while (q.right != null) {
			q = q.right;
		}
		return (E) q.info;
	}
	public  E findMin() {
		if(root == null ) {
			return null;
		}
		Node q = root;
		while (q.left != null) {
			q = q.left;
		}
		return (E) q.info;
	}
	public boolean find(Comparable<E> x) {
		return find(root,x);
	}
	static boolean  isPrime(int x) {
		if(x < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if(x%i == 0)
				return false;
		}
		return true;
	}
	private int  sumPrime(Node r) {
		if(r == null) {
			return 0;
		}
		if (isPrime((int)r.info)) {
			return (int) r.info + sumPrime(r.right) + sumPrime(r.left);
		}
		return sumPrime(r.right) + sumPrime(r.left);
	}
	public int sumPrime() {
		return sumPrime(root);
	}
	
	private int findLevel( Node r , E value) {
		if(r == null) {
			return 0;
		}
		if(r.info==(E)(Integer)value) {
			return 1;
		}
		if( (Integer) r.info <(Integer) value) {
			return 1 + findLevel(  r.right ,  value);
		}
		return 1+findLevel(  r.left ,  value);
		
		
	}
//	
//	public void findcin(E value) {
//		System.out.println(findLevel(root, value));
//	}
//	
	
	
	
	///// tim bac co nhieu node nhat 
	
	private void findLevelHaveNodeMax(Node r, ArrayList<Integer> a  ) {
		
		if( r!=null) {
			a.add((Integer) findLevel(root, (E)r.info)  );
			findLevelHaveNodeMax( r.left,  a  );
			findLevelHaveNodeMax( r.right,  a );
		}
	}
	
	public void findLevelHaveNodeMax() {
		
		ArrayList<Integer> a= new ArrayList<Integer>();
		
		findLevelHaveNodeMax(root,a);
		
		
	}

	public static void main(String agrs[]) {
		BST<Integer> b1 = new BST<Integer>();
		b1.add(3);
		b1.add(2);
		b1.add(0);
		b1.add(5);
		b1.add(100);
		b1.inOrder();
//		System.out.println(b1.find(10));
//		System.out.println(b1.findMax());
		System.out.println("Tong so nguyen to = " + b1.sumPrime());
	}
}
