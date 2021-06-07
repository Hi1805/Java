package array_of_rectangle;

import java.util.Scanner;

import test_array_list.MyNumber;

public class Rectangle extends MyNumber{
	private double width;
	private double length;
	
	public Rectangle () {
		
	}
	public Rectangle (double width,double length) {
		this.width = width;
		this.length = width;
	}
	public void input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please Enter Width");
		width = kb.nextDouble();
		System.out.println("Please Enter Length");
		length = kb.nextDouble();
	}
	
	public String toString() {
		return "Width :"+this.width +"\n"+"length :"+this.length + "\n";
	}
	
	public double perimeter () {
		return (length + width)*2;
	}
	public double area() {
		return length * width;
	}
	@Override
	public double value() {
		// TODO Auto-generated method stub
		return area();
	}
}
