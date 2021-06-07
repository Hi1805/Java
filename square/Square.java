package square;

import java.util.Scanner;


public class Square { // hinh vuong
	private double a;
	
	// thuoc tinh , phuong thuc
	// chiec o to :
	// => banh xe, kinh , cop xe ..
	
	//phuong thuc : chay xe 
	public Square () {
		a = 0;
	}
	
	public Square (double a) {
		this.a = a;
	}
	// input , output , dientich, chuvi,toString => methods
	 
	public void input() {
		Scanner kb =  new Scanner(System.in);
		System.out.println(" Nhap a :");
		a = kb.nextDouble();
	}
	
	public void output() {
		System.out.println("Do dai canh la " + a);
	}
	
	@Override
	public String toString() {
		return "do dai canh la " + a;
	}
	// chu vi
	public Square tongChuVi(Square s) { // s = s2 , this = s1
		double tong = this.chuvi() + s.chuvi();
		// tra 1 hinh vuong co do dai la canh bang tong 2 canh
		Square square  = new Square();
		square.a = tong;
		return square;
	}
	public double chuvi() {
		return a*4;
	}
	public double dientich() {
		return a*a;
	}
	
	public static void main(String agrs[]) {
		Square s1 = new Square();		
		s1.input();
		Square s2 = new Square();
		s2.input();
		
		System.out.println("tong chu vi la "+s1.tongChuVi(s2).toString());
		// con tro this luc nay la s1
		System.out.println("tong chu vi la "+s1.tongChuVi(s2).tongChuVi(s2).toString());
		//System.out.println(s1.tongChuVi(s2));
		// <=> s1.chuvi + s2.chuvi + s2.chuvi
		// this  luon chua dia chi cua doi tuong
		// this = s1
		// this = s1.tongchuvi(s2) => tra ve 1 dia chi
		
	}
}
