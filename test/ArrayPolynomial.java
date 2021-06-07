package test;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayPolynomial {
	ArrayList<Polynomial> arrayList  = new ArrayList<Polynomial>();
	
	 public ArrayPolynomial() {
		arrayList = new ArrayList<Polynomial>(10);
	}
	public ArrayPolynomial(int cap) {
		arrayList = new ArrayList<Polynomial>(cap);
	}
	public void input() {
		int n = 0;
		System.out.println("nhap n");
		n = (new Scanner(System.in)).nextInt();
		for (int i = 0; i <=n; i++) {
			System.out.println("Enter"+(i+1));
			Polynomial p1 = new Polynomial();
			p1.input();
			
			arrayList.add(p1);
		}
	}

	public double value(double x) { // f(x0);
		double value = 0;
		for (int i = 0; i < arrayList.size(); i++) { //
			value += arrayList.get(i).getA()*Math.pow(x,arrayList.get(i).getSomu());
		}
		return value;
	} // 2*x^1 + 2 , x = 2 => 6
	// 
	public double fValue(double x) {// dao ham f(x0);1 +2*2*2+3*3*2*2
		double value = 0;
		for (int i = 1; i < arrayList.size(); i++) {
			int somu = arrayList.get(i).getSomu();
			value += arrayList.get(i).getA()*Math.pow(x, somu-1)*i;
		}
		return value;
	}
	
	@Override
	public String toString() {
		return "ArrayPolynomail [arrayList=" + arrayList.toString() + "]";
	}
	public static void main(String agrs[]) {
		ArrayPolynomial a1 = new ArrayPolynomial();
		a1.input();
		System.out.println(a1);
		System.out.println(a1.value(3));
		System.out.println(a1.fValue(2));// dao ham
		
	}
}
