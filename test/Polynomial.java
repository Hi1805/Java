package test;

import java.util.ArrayList;
import java.util.Scanner;




public class Polynomial {
	private int a;
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getSomu() {
		return somu;
	}

	public void setSomu(int somu) {
		this.somu = somu;
	}

	private int somu ;
	
	public void input() {
		System.out.println("nhap he so a");
		a = (new Scanner(System.in)).nextInt();
		System.out.println("nhap so mu");
		somu = (new Scanner(System.in)).nextInt();
	}

	@Override
	public String toString() {
		return  a + "x^" + somu ;
	}
	
	
}

