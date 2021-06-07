package stack;

public class MyStack_Array<E> {
	private E[] a; 
	private static int size ;
	private int top;
	public MyStack_Array(){
		a  = (E[]) new Object[10];
		size = 0;
		top = -1;
	}
	public static boolean isEmpty() {
		return  size == 0 ;
	}
	public E peek() {
		if(size == 0) {
			System.out.println("Is Empty");
			return null;
		}
		return a[top];
	}
	public E  pop() {
		if(isEmpty()) {
			return null;
		}
		top-- ;
		return a[--size];

	}
	public E push(E element) {
		if(size == a.length ) {
			return null;
		}
		a[++top] = element;
		size ++;
		return element;
	}
	public String  toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			if(a[i] != null)
				s = s + a[i]+ " ";
		}
		return s;
	}
	public static void main(String agrs[]) {
		MyStack_Array<Integer> m1 = new MyStack_Array<Integer>();
		m1.push(1);
		m1.push(3);
		m1.push(5);
		System.out.println(m1.pop());
		System.out.println(m1);
		
	}
}
