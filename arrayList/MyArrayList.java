package arrayList;

import java.time.Year;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;



import array_of_fraction.Fraction;
import array_of_rectangle.Rectangle;


public class MyArrayList<E> {
	private  E a[]; 
	private int n ;
	
	public MyArrayList() {
		 a = (E[]) new Object[10];//ep kieu tu object sang kieu E
	}
	public MyArrayList(int cap) {
		a = (E[]) new Object[cap];
	}
	
	public E get(int index) {
		if (index >= n || index < 0) {
			System.out.println("Index invaild");
			return null;
		}
		return a[index];
	}
	
	public void set(int index, E  f) {
		if (index >= n || index < 0) {
			System.out.println("Index invaild");
		} else {
			a[index] = f;
		}
	}

	public void add(E f) {
		if (n == a.length) {
			E [] newArr = (E[]) new Object [a.length * 2];
			for (int i = 0; i < n; i++) {
				newArr[i] = a[i];
			}
			a = newArr;
		}
		a[n] = f;
		n++;
	}

	public void add(int index, E  e) {
		if (index < 0 || index > n) {
			System.out.println("avalid index");
			return;
		}
		if (n == a.length) {
			E [] b =(E[]) new Object [a.length * 2];
			for (int i = 0; i <= n; i++) {
				b[i] = (i > index) ? a[i - 1] : a[i];
			}		
			a = b;

		}
		else {
			for (int i = n; i > index; i--)
				a[i] = a[i - 1];

		}
		a[index] = e;
		n++;
	}

	public void remove(int index) {
		if (index >= n || index < 0)
			System.out.println("Error");
		else {
			for (int i = index; i < n - 1; i++) {
				a[i] = a[i + 1];
			}
			n--;
		}
	}

	public boolean contains(Object  object) { // kiem tra x co chua trong mang hay khong
		for (int i = 0; i < n; i++) {
			if (a[i].equals(object) )
				return true;
		}
		return false;
	}
	// containsAll
	public boolean containsAll(MyArrayList  aList) {
		for (int i = 0; i <aList.size() ; i++) 
			if(! contains (aList.get(i) ) ) {
					return false;
			}

		return true;
	}
	
//	// vi tri dau tien cua x trong mang
	public int indexOf(E  x) {
		for (int i = 0; i < n; i++) {
			if (a[i].equals(x))
				return i;
		}
		return -1;
	}

//	// tim vi tri cuoi cung x trong mang
	public int lastIndexOf(E  x) {
		;
		for (int i = n - 1; i > 0; i--) {
			if (a[i].equals(x))
				return i;
		}
		return -1;
	}
//
	//To String 
	public String toString() {
		String s = "[";
		for (int i = 0; i < n; i++) {
			s = s + a[i].toString() + ","; 
		}
		return s+"]";
	}
	
	public int size() {
		return n;
	}
	
	//Clear
	public void clear() {
		a = (E[]) new Object[0];
	}
	
	//forEach
	public void forEach(Consumer <E> x) {
		
		x = new Consumer<E>() { // khach hang 
			@Override
			public void accept(E t) {
				System.out.println(t);
			}
		};
		for (int i = 0; i < size(); i++) {
			x.accept(a[i]);
		}
	}
	

	
	
//	public void sort(Comparator<Integer> x) {
//		x = new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				o1 = 1; o2 = 0;
//				int check = o1-	o2;
//				if(o1 > o2 ) {
//					
//				}
//				return 0;
//			}
//			
//		};
//	}
	public static void main (String agrs[]) {
////		ArrayList<Rectangle> f1  = new ArrayList<Rectangle>();
////		Rectangle f2 = new Rectangle(2,3);	
////		f1.add(f2);
////		f1.add(f2);
//		//System.out.println(f1.contains(f2));
//		//System.out.println(f1);
//		
//		//==== ArrayList cua java
//		ArrayList<Integer> I1  = new ArrayList<Integer>();
//		I1.add(-2);
//		I1.add(-3);
//		I1.add(-5);
//		
////	 	I1.sort();
////		I1.clear();
//		
////		ArrayList<Integer> testI1  = new ArrayList<Integer>();
////		testI1.add(-3);
////		testI1.add(-2);
////		System.out.println(I1.containsAll(testI1));//true
////		testI1.add(-4);
////		System.out.println(I1.containsAll(testI1));// false
//		
//		
//		
//		I1.forEach((element)->{ 
//			System.out.println(element);
//		});
//		
//		
//		
//		//============ test gia lap 
////		MyArrayList<Integer> MYI  = new MyArrayList<Integer>();
////		MYI.add(-2);
////		MYI.add(-3);
////		MYI.add(-5);
//////		I1.clear();
//		
//		MyArrayList<Integer> MtestI  = new MyArrayList<Integer>();
//		MtestI.add(-3);
//		MtestI.add(-2);
////		System.out.println(MYI.containsAll(MtestI));//true
////		MtestI.add(-4);
////		System.out.println(MYI.containsAll(MtestI));// false
////		
//		
//		MtestI.forEach((element)->{
//			System.out.println(element);
//		});
//		
//		
//		
//		
////		System.out.println(I1.toString());
////		System.out.println(I1.indexOf(2));
////		
////		
////		MyArrayList<Integer> I2  = new MyArrayList<Integer>();
////		I2.add(-2);
////		I2.add(-2);
////		I2.add(-2);
////	//	I2.output();
////		I2.clear();
////		System.out.println(I1.toString());
////		System.out.println(I1.indexOf(2));
//		
		int a [] = {1,2,3,4};
		int [] b = 	Arrays.copyOf(a,a.length*2);
		
		for (int i : a) {
			System.out.println(i);
		}
	}
}


