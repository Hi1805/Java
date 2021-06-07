package arrayofcircle;
import java.util.Scanner;

import array_of_fraction.Fraction;
public class ArrayOfCircle {


	private int  n ;
	private Circle[] a;

	public ArrayOfCircle() {
		this.n=0;
		this.a=new Circle[100];

	}

	public ArrayOfCircle(int   x) {
		this.n = x;

	}

	public int getN() {
		return this.n;
	}


	public void set(int index, int element) {
		Scanner input = new Scanner(System.in);

		if(index < 0 || index >= n) {
			System.out.println("Invalid index");
		}else {
			this.a[index].setRadius(element);
		}
	}

	// GET : tráº£ vá»� giÃ¡ trá»‹ cá»§a index trong máº£ng Ä‘Æ°á»£c chá»‰ Ä‘á»‹nh 
	public Circle getCircle(int index) { 
		if( index < 0 || index >= this.n) {
			System.out.println("Invalid index");
			return null; 
		}
		else {
			return this.a[index]; // tráº£ vá»� Ä‘á»‹a chá»‰
		}
	}
	// CONTAINS() METHOD
	public boolean contains(Circle element) {
		for(int i = 0; i < this.n; i++) {
			if (element.getRadius() == this.a[i].getRadius()) {
				return true;
			}
		}
		return false;
	}
	// INDEXOF() METHOD
	public int indexOf(Circle element) {
		for(int i = 0; i < this.n; i++) {
			if(this.a[i].getRadius()	 == element.getRadius()) {
				return i;
			}
		}
		return -1;
	}
	public int lastIndexOf(Circle element) { 
		for(int i = n -1 ; i >= 0; i--) {
			if(this.a[i].getRadius() == element.getRadius()) {
				return i;
			}
		}
		return -1;
	}
	// REMOVE() METHOD
	public void remove(int index) {
		if(index < 0 || index >= n) {
			System.out.println("Invalid index");
			return;
		}
		for (int i = index; i < this.n - 1; i++) {
			this.a[i] = this.a[i + 1];
		}
		n--;

	}

	// ThÃªm 1 pháº§n tá»­ Circle nÃ o Ä‘Ã³ vÃ o vá»‹ trÃ­ index trong máº£ng arr gá»“m n pháº§n tá»­ 
	public  void insert(int index, Circle x) {

		if(index < 0 || index > this.a.length) {
			System.out.println("Invalid index");
			return;
		}
		if (index > this.n) { // Náº¿u chÃ¨n táº¡i vá»‹ trÃ­ khÃ´ng liÃªn tiáº¿p trong máº£ng , táº¡i index = n lÃ  chÃ¨n vÃ o cuá»‘i máº£ng, thá»±c hiá»‡n tá»« line 123
			System.out.println("Cannot insert");
			return;
		}
		// Náº¿u máº£ng Ä‘áº§y
		if (this.n == this.a.length) {
			Circle newArr[] = new Circle[this.a.length*2]; // Khá»Ÿi táº¡o máº£ng má»›i vá»›i sá»‘ pháº§n tá»« = x2 sá»‘ pháº§n tá»­ máº£ng cÅ©
			for(int i = 0; i < this.a.length; i++) {
				if(i >= index) { // Chá»«a vá»‹ trÃ­ index ra
					newArr[i + 1] = this.a[i]; 
				}
				else {
					newArr[i] = this.a[i]; // di chuyá»ƒn tá»«ng pháº§n tá»­ cá»§a máº£ng cÅ© sang máº£ng má»›i
				}
			}
			System.out.println("Máº£ng Ä‘áº§y, Ä‘Ã£ tÄƒng Ä‘á»™ dÃ i máº£ng tá»« " + this.a.length + " => " + newArr.length);
			this.a = newArr;	// Thay Ä‘á»•i Ä‘á»‹a chá»‰ cho máº£ng this.arr(thuá»™c tÃ­nh) cá»§a Ä�á»‘i tÆ°á»£ng máº£ng "arr" Ä‘Æ°á»£c khai bÃ¡o vÃ  cáº¥p phÃ¡t vá»›i class ArrayOfInteger( bÃªn trong cÃ³ chá»©a máº£ng arr);
		}else {
			// Náº¿u máº£ng chÆ°a Ä‘áº§y
			// Náº¿u index vÃ o cuá»‘i máº£ng => index = n => for khÃ´ng thá»±c hiá»‡n
			for (int i = n; i > index; i--) {
				this.a[i] = this.a[i - 1];
			}
		}

		this.a[index] = x;
		this.n ++;
	}
	public void input() {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter length of array , n= ");
		this.n=input.nextInt();	   			
		for(int i=0;i<this.getN();i++) {
			System.out.println("Enter a["+i+"] ");
			this.a[i]=new Circle();//Tao DIA CHI cho tung doi tuong trong mang
			this.a[i].input();
		}
	}

	public void output() {
		System.out.println("Array of Circle");
		for(int i=0;i<this.getN();i++) {
			System.out.print("a["+i+"] = ");
			this.a[i].output();
			//System.out.println(this.array[i]);//In ra dia chi tung doi tuong trong mang ,n=5 =>mang co 5 doi tuong
		}
	}

	public static void main(String[]args) {
		ArrayOfCircle array = new ArrayOfCircle();

		array.input();
		array.output();
		System.out.println("======================");
		System.out.println("Add");
		// output 						1   0 
		//								2   1
		Circle cir = new Circle(4);//	4   2
		Circle cir1 = new Circle(5);//  5   3
		//     							9   4
		// 									5
		array.insert(2, cir);
		array.insert(3, cir1);
		array.insert(0, new Circle(9));
		array.output();

		System.out.println("==========================");
		System.out.println("Remove");
		array.remove(2);
		array.output();

	}	
}




