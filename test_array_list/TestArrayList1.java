package test_array_list;

import java.util.ArrayList;
import java.util.Scanner;
import array_of_double.Double;
import array_of_fraction.Fraction;
import array_of_integer.Integer;
import array_of_rectangle.Rectangle;
import arrayofcircle.Circle;
public class TestArrayList1 {
	ArrayList<MyNumber> numbers =  new ArrayList<MyNumber>();
	
	void input() {
		System.out.println("Nhap n ");
		Scanner kb = new Scanner(System.in);
		int n  = kb.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("1/Integer 2/Double  3/Fraction 4/Circle 5/Rectangle");
			int choose = kb.nextInt();
			switch (choose) {
				case 1: {
					Integer f1 = new Integer();
//					MyNumber m1 = new MyNumber();
					
					System.out.println("nhap so <Dang Integer>");
					f1.nextInt();
					numbers.add(f1);
					break;
				}
				case 2: {
					Double f1 = new Double();
					System.out.println("nhap so <Dang Double >");
					f1.nextDouble();
					numbers.add(f1);
					break;
				}
				case 3: {
					Fraction f1 = new Fraction();
					f1.input();
					numbers.add(f1);
					break;
				}
				case 4: {
					Circle f1 = new Circle();
					f1.input();
					numbers.add(f1);
					break;
				}
				case 5 :{
					Rectangle f1 = new Rectangle();
					f1.input();
					numbers.add(f1);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choose);
				}
		}
	}
	public double sum() { // tinh tong value
		double sum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum+= numbers.get(i).value();
		}
		return sum;
	}
	public static	void main	(String agrs[]) {
		TestArrayList1 t1 = new TestArrayList1();
		t1.input();
		System.out.println(t1.sum());
	}
}
