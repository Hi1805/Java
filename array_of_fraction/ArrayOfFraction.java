package array_of_fraction;

import java.util.Scanner;

import functions.Functions;

public class ArrayOfFraction {
	private Fraction a[];
	private int n;

	public ArrayOfFraction() {
		a = new Fraction[3];
		n = 0;
	}

	public ArrayOfFraction(int capcity) {
		a = new Fraction[capcity];
		n = 0;
	}

	public Fraction get(int index) {
		if (index >= n || index < 0) {
			System.out.println("Index invaild");
			return null;
		}
		return a[index];
	}

	public void set(int index, Fraction f) {
		if (index >= n || index < 0) {
			System.out.println("Index invaild");
		} else {
			a[index] = f;
		}
	}

	public void add(Fraction f) {
		if (n == a.length) {
			Fraction[] newArr = new Fraction[a.length * 2];
			for (int i = 0; i < n; i++) {
				newArr[i] = a[i];
			}
			a = newArr;
		}
		a[n] = f;
		n++;
	}

//	public void add(int index , Fraction f) {
//			if(index > n || index < 0)
//				System.out.println("Index invalid");
//			else {
//				if(n == a.length) { // kiem tra mang da day hay chua
//					Fraction newArr[] = new Fraction[a.length*2];
//					for(int i = 0;i<a.length;i++) {//sao chep mang, de danh vi tri index
//						if(i >= index) {
//							newArr[i+1] = a[i];
//						}
//						else {
//							newArr[i] = a[i];
//						}
//					}
//					
//					newArr[index] = f;
//					a = newArr;			
//				}		
//				else { // neu mang k day thi chen binh thuong
//					for (int i = n; i >index; i--) {
//							a[i] = a[i-1];
//					}
//					a[index] = f;
//				}
//				n++;
//			}
//	}
	public void add(int index, Fraction e) {
		if (index < 0 || index > n) {
			System.out.println("avalid index");
			return;
		}
		if (n == a.length) {
			Fraction[] b = new Fraction[a.length * 2];
			for (int i = 0; i <= n; i++) {
				if (i > index) {
					b[i] = a[i-1];
				}
				else b[i] = a[i];
			//	b[i] = (i > index) ? a[i - 1] : a[i];
			}
			a = b;

		}
		else {
			for (int i = n; i > index; i--)
				a[i] = a[i - 1];

		}
		// b[1] = 2; a =>
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

	public boolean contains(Fraction x) { // kiem tra x co chua trong mang hay khong
		for (int i = 0; i < n; i++) {
			if (a[i].value() == x.value())
				return true;
		}
		return false;
	}

	// vi tri dau tien cua x trong mang
	public int indexOf(Fraction x) {
		for (int i = 0; i < n; i++) {
			if (a[i].value() == x.value())
				return i;
		}
		return -1;
	}

	// tim vi tri cuoi cung x trong mang
	public int lastIndexOf(Fraction x) {
		;
		for (int i = n - 1; i > 0; i--) {
			if (a[i].value() == x.value())
				return i;
		}
		return -1;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < n; i++) {
			s = s + a[i] + " ";
		}
		return s;
	}

	public void output() {
		for (int i = 0; i < n; i++) {
			a[i].output();
			System.out.println();
		}

	}

}
