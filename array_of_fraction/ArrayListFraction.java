package array_of_fraction;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListFraction {
	ArrayList<Fraction> arrayList = new ArrayList<Fraction>();
	public ArrayListFraction() {
		// TODO Auto-generated constructor stub
	}
	public  ArrayListFraction(ArrayList<Fraction> x){
		arrayList = x;
	}
	public  ArrayListFraction (int cap ){
		arrayList = new ArrayList<Fraction>(cap);
	}
	
	public void input() {
		System.out.println("Enter n ");
		int n  = (new Scanner(System.in)).nextInt();
		for (int i = 0; i < n; i++) {
			 System.out.println("Enter Fraction "+i );
			 Fraction f1 = new Fraction();
			 f1.input();
			 arrayList.add(f1);
		}
	}
	
	public Fraction sum() {
		Fraction sum = new Fraction(0,1) ;

		for (int i = 0; i < arrayList.size(); i++) {
			sum = sum.plus(arrayList.get(i));
		}
		return sum;	
	}
	public void removeDenominatorEven() {
		for (int i = 0; i < arrayList.size(); ) {
			if(arrayList.get(i).getDenominator() % 2 == 0 ) {
				arrayList.remove(i);
			}
			else i++;
		}
	}
	public String toString() {
		return arrayList.toString();
	}
	public void swap(int i , int j) {
		Fraction fr = arrayList.get(j);
		arrayList.set(j,arrayList.get(i));
		arrayList.set(i,fr);
	}
	public void sortDescending() {
	
		//arrayList.sort((a,b)->a.divide() - b.divide()); // functional internal tra ve int -> tra double la loi
		
		for (int i = 0; i < arrayList.size(); i++) {
			for (int j = 0; j < arrayList.size() - i - 1; j++) {
				if(arrayList.get(j).value() > arrayList.get(j+1).value()) {
					System.out.println("huy");
					swap(j, j+1);
				}
			}
		}
	}
	public static  void main(String agrs[]) {
		ArrayListFraction a1 = new ArrayListFraction();
		a1.input();
		//a1.sum().output();
		//a1.removeDenominatorEven();
		System.out.println(a1);
		a1.sortDescending();
		System.out.println(a1);
		
	}
}
