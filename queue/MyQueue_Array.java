package queue;

import java.util.LinkedList;
import java.util.Queue;

import Exam.LinkedListt;

public class MyQueue_Array <E>{
	private E[] a;
	private int head,tail,size;
	public MyQueue_Array() {
		head = tail = size = 0;
		a =  (E[]) new Object[10];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	public E element() {
		if (size == 0 ) {
			return null;
		}
		return a[head];
	}
	public boolean add(E e) {
		
		if (size ==  a.length) {
			return false;
		}
		a[tail++] = e;
		tail = tail%a.length;
		size++;
		return true;
	}
	public E remove () {
		if(size  ==  0)
			return null;
		E temp = a[head];
		a[head++ ] = null;
		head %= a.length;
		size--;
		return temp;	
	}
	public String toString() {
		String s = "";
		int head2 = head;
		for (int i = 0; i < size; i++) {
			s += a[(head2 + i) % a.length] + " ";
		}
		return s;
	}
	public static void main(String agrs[]) {
		MyQueue_Array<Integer> m1 = new MyQueue_Array<Integer>();
		m1.add(10);
		m1.add(-9);
		m1.add(-3);
		m1.add(20);
		m1.remove();
		
	}
}
