package array_of_integer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import functions.Functions;

public class ArrayOfInteger  {
	public int a[];
	public int n;
	public ArrayOfInteger() {
		a = new int [3];
		n=0;
	}
	public ArrayOfInteger( int capacity) {
		a  = new int[capacity];
		n = 0;
	}
	
	
	//them 1 phan tu element vao cuoi mang a gom n phan tu
	public void add(int element) {
		
		if(n==a.length) {
			int b[] = new int [a.length*2];
			for(int i = 0;i<a.length;i++) {
				b[i] = a[i];
			}
			a=b;
		}
		
		a[n] = element;
		n++;
		}
	//hàm get
	public int get(int index) {
		if(index >=n ||index<0) {
			System.out.println("Index invalid");
			return -1;
		}
		return a[index];
	}
	//ham set
	public void set(int index,int element) {
		if(index >=n ||index<0) {
			System.out.println("Index invalid");
		}
		else {
			a[index]  = element;	
		}
	}
	public void output() { // in , nhap
//		for(int i :a) {
//			System.out.print(i+" ");
//		}
		for(int i = 0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
		
	}
	public boolean contain(int x) { // kiem tra x co chua trong mang hay khong
		for (int i = 0; i < n; i++) {
			if(a[i] == x)
				return true;
		}
		return false;
	}
	// vi tri dau tien cua x trong mang
	public int indexOf (int x) { 
		for (int i = 0; i < n; i++) {
			if(a[i] == x)
				return i;
		}
		 return -1;
	}
	// tim vi tri cuoi cung x trong mang
	public int lastIndexOf (int x) {
		int index = 0;
		boolean check = false;
		for (int i = 0; i < n; i++) {
			if(a[i] == x) {
				index = i;
				check = true;
			}
		}
		if(check)
			return index;
		return -1;
	}
	// xoa 1 phan tu ra khoi mang 
	public void remove(int index) {
		if(index >= n || index <0)
			System.out.println("Error");
		else {
			for (int i = index; i < n-1; i++) {
				a[i] = a[i+1];
			}
			n--;
			System.out.println(n);
		}
	}
	//xoa phan tu x trong mang 
	public void removeElement(int element) {
		for (int i = 0; i <n;) {
			if(element == a[i]) {
				remove(i);
			}
			else i++;
		}
	}

//	public void add(int index, int element) {
//		if(index > n || index < 0)
//			System.out.println("Index invalid");
//		else {
//			if(n == a.length) { // kiem tra mang da day hay chua
//				int newArr[] = new int[a.length*2];
//				for(int i = 0;i<a.length;i++) {//sao chep mang, de danh vi tri index
//					if(i >= index) {// index = 0; a[i] => i = index => a[index ] = element;
//						newArr[i] = a[i];
//					}
//					else {
//						newArr[i] = a[i];
//					}
//				}	
//				newArr[index] = element;
//				a = newArr;
//			
//			}
//			
//			else { // neu mang k day thi chen binh thuong
//				for (int i = n; i >index; i--) {
//						a[i] = a[i-1];
//				}
//				a[index] = element;
//			}
//			n++;
//		}
//			
//	}
	public void add(int index, int e) {
		if(index<0 || index>n) {
			System.out.println("avalid index");
			return;
		}
		if(n==a.length) {
			int[]b = new int[a.length*2];
			for(int i=0;i<=n;i++) { 
				b[i]=(i>index)?a[i-1]:a[i];
			}
			a=b;
		}
		else {
		  for(int i=n;i>index;i--) 
			  a[i]=a[i-1];
	    }
		//b[1] = 2; a => 
		a[index]=e;
		n++;
	}
	public String toString()
	{
		String  s = "";
		for (int i = 0; i < n; i++) {
			s = s + a[i]+" ";
		}
		return s;
	}

	public static void main(String agrs[]) {
		// o nho la 3
		//khai bao va cap phat 1 o nho chua  doi tuong mang
		ArrayOfInteger a1 = new ArrayOfInteger();
		a1.add(30);
		a1.add(30);
		a1.add(40);
		a1.add(1,6);
//		a1.add(1,7);
//		a1.add(1,8);
//		a1.output();
//		Random r1 = new Random(123);
//		System.out.println(Math.random());
//		System.out.println(r1.nextInt());
//		System.out.println(a1.lastIndexOf(100));
//		System.out.println(a1.a.length);
//		a1.removeElement(30);
//		a1.output();
//		System.out.println(a1.toString());// goi tuong minh to String
		System.out.println(a1);//goi khong tuong minh, neu co ToString  thi java tu dong goi toString();
		


	}
	
	
}
