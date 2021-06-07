package Exam;

import java.util.Stack;

public class Cau11<E> {
	
	void   stackDuplicate(Stack<E> st1 , Stack<E>  st2) {
		Stack<E> st3 = new Stack<E>();
		while (!st1.isEmpty()) {
			st3.add(st1.pop());
		}
		while (!st3.isEmpty()) {
			st1.add(st3.peek());
			st2.add(st3.pop());
		}
	}
	public static void  main(String agrs[]) {
		Cau11 c1 = new Cau11<Integer>(); // 1 2 3 4 
		
		Stack<Integer> st1  = new Stack<Integer>();
		st1.add(1);
		st1.add(2);
		st1.add(3);
		st1.add(4);
		st1.add(5);
		st1.add(6);
		Stack<Integer> st2  = new Stack<Integer>();
		c1.stackDuplicate(st1, st2);
		System.out.println(st1.peek());
		System.out.println(st2.peek());
	}
}
