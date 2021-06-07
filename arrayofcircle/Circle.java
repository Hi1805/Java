package arrayofcircle;

import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;

import test_array_list.MyNumber;

public class Circle extends MyNumber {
	private	double radius;
//	 public void forEach(Consumer<? super Circle> action) {
//	        Objects.requireNonNull(action);
//	        final int expectedModCount = modCount;
//	        final Object[] es = elementData;
//	        final int size = this.size;
//	        for (int i = 0; modCount == expectedModCount && i < size; i++)
//	            action.accept(elementAt(es, i));
//	        if (modCount != expectedModCount)
//	            throw new ConcurrentModificationException();
//	    }
	public  Circle() {//Ham khoi tao khong co doi so
		radius = 0;
	}
	
	public  Circle(double x) {//Ham khoi tao co doi so
		radius = x;
	}

	public 	void input()//INPUT
	{
		Scanner input = new Scanner (System.in);
		System.out.println("Enter radius:");
		this.radius = input.nextDouble();
		setRadius(this.radius);
		
	}
	public void output() {
		System.out.println("Radius:" + this.radius);
	}
	public void setRadius(double element) {//SET	
		Scanner input=new Scanner(System.in);
		if(element < 0)
			{
			while(element < 0) {
				System.out.println("Enter radius > 0:");		
				 element = input.nextDouble();
				 }
			this.radius = element;
			}
		else this.radius = element;
	}
	
	public double getRadius() {//GET
		return this.radius;
	}
	public double area()//Computing AREA
	{
		return Math.PI*this.radius*this.radius;
	}
		
	public double perimeter()//Computing Perimeter
	{
		return 2*Math.PI*this.radius;
	}
	
	public String toString() {
		return "Radius: " + this.radius;
	}
	public static void main(String []args) {
		Circle  circle = new Circle();
		circle.input();
		circle.output();
		
		System.out.println(circle.area());
		System.out.println(circle.perimeter());
		System.out.println( circle );
	}

	@Override
	public double value() {
		// TODO Auto-generated method stub
		return area();
	}


}
