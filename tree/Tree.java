package tree;

public class Tree <E> {
	private class Node{
		private E info;
		private Node left, right;
		public Node(E info) {
			this.info = info;
			this.left = this.right = null;
		}
		public Node(E info , Node l, Node r) {
			this.info = info;
			this.left = l;
			this.right =r;
		}
		
	}
	private Node root= null;
	public   Tree() {
		Node r8 = new Node((E)(Character)'I');
		Node r6= new Node((E)(Character)'H',null,r8);
		Node r4 = new Node((E)(Character)'F',r6,null);
		Node r5= new Node((E)(Character)'K',null,new Node((E)(Character)'G'));
		Node r2= new Node((E)(Character)'C',r4,r5);
		Node r1= new Node((E)(Character)'B',new Node((E)(Character)'E'),null);
		root = new Node((E)(Character)'A',r1,r2);
	}
	private void inOrder(Node r) {
		if(r!=null) {
			System.out.print(r.info+ " ");
			inOrder(r.left);
			inOrder(r.right);
		}
	}
	public void inOrder() {
		inOrder(root);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree<Character> t = new Tree<Character>();
		t.inOrder();
	}
	
}