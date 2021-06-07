package array_of_rectangle;

import java.util.Scanner;

import functions.Functions;

public class Array_Of_Rectangle {
	private Rectangle a[];
	private int n ;
	
	 public Rectangle[] getA() {
		return a;
	}
	public void setA(Rectangle[] a) {
		this.a = a;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public Array_Of_Rectangle() {
		 a = new Rectangle [3];
		 n = 0;
	} 
	 public Array_Of_Rectangle (int capacity) {
		a = new Rectangle [capacity];
		n = 0;
	}
	 
	public void input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please Enter Number ");
		n = kb.nextInt();
		
		a = new Rectangle [n];
		for (int i = 0; i < n ; i++) {
			System.out.println("Enter a[" + i + "]");
			a[i] = new Rectangle();
			a[i].input();
		}
	}
	public void add(Rectangle f) {
		if( n == a.length ) {
			Rectangle[] newArr = new Rectangle[a.length * 2];
			for (int i = 0; i < n; i++) {
				newArr[i] = a[i];
			}
			a  = newArr ;
		}
		a[n] = f;
		n++;
	}
	
	public void add(int index , Rectangle f) {
		if(index > n || index < 0)
			System.out.println("Index invalid");
		else {
			if(n == a.length) { // kiem tra mang da day hay chua
				Rectangle newArr[] = new Rectangle[a.length*2];
				for(int i = 0;i<a.length;i++) {//sao chep mang, de danh vi tri index
					if(i >= index) {
						newArr[i+1] = a[i];
					}
					else {
						newArr[i] = a[i];
					}
				}
				
				newArr[index] = f;
				a = newArr;			
			}		
			else { // neu mang k day thi chen binh thuong
				for (int i = n; i >index; i--) {
						a[i] = a[i-1];
				}
				a[index] = f;
			}
			n++;
		}
}
		public void remove(int index) {
			if(index >= n || index <0)
				System.out.println("Error");
			else {
				for (int i = index; i < n-1; i++) { 
					a[i] = a[i+1];
				}
				n--;
			}
		}
		public boolean contains(Rectangle x) { // kiem tra x co chua trong mang hay khong
			for (int i = 0; i < n; i++) {
				if(a[i].area() == x.area())
					return true;
			}
			return false;
		}
		// vi tri dau tien cua x trong mang
		public int indexOf (Rectangle x) { 
			for (int i = 0; i < n; i++) {
				if(a[i].area() == x.area())
					return i;
			}
			 return -1;
		}
		// tim vi tri cuoi cung x trong mang
		public int lastIndexOf (Rectangle x) {;
			for (int i = n - 1; i > 0; i--) {
				if(a[i].area() == x.area())
					return i ;
			}
			return -1;
		}
			
		public String toString() {
			String s = "";
			
			for (int i = 0; i < n; i++) {
				s = s +"a["+ i +"] \n" + a[i].toString() + "\n";
				}
			return s;
		}
	
	public static  void main(String agrs[]) {
		Array_Of_Rectangle arr1 = new Array_Of_Rectangle();
		arr1.input();
		System.out.println(arr1);
		Rectangle r1 = new Rectangle();
		r1.input();
		arr1.add(r1);
		System.out.println(arr1);
		System.out.println(arr1.a[0].area());
	
	}
}