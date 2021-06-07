package array_of_fraction;

import java.util.Scanner;

import test_array_list.MyNumber;


public class Fraction extends MyNumber {
	private int numerator, denominator;

	public Fraction () {
		
	}
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		if(denominator == 0) {
			this.denominator = 1;
		}
		else
			this.denominator = denominator;
	}
	
	public void input() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please Enter numerator");
		numerator = kb.nextInt();
		System.out.println("Please Enter denominator ");
		setDenominator(kb.nextInt());
		
	}
	public void output() {
		int check  = denominator * numerator;
		if(check >= 0) {
			System.out.println(Math.abs(this.numerator) +"/" + Math.abs(this.denominator));
		}
		else 
			System.out.println( "-"+Math.abs(this.numerator) +"/" + Math.abs(this.denominator));
	}
	
	@Override
	public String toString() {
		int check  = denominator * numerator;
		if(check >= 0) {
			return (Math.abs(this.numerator) +"/" + Math.abs(this.denominator));
		}
			return ( "-"+Math.abs(this.numerator) +"/" + Math.abs(this.denominator));
	}
	
	public Fraction plus( Fraction f ) {
		Fraction f1  = new Fraction();
		f1.numerator = this.numerator * f.denominator + this.denominator * f.numerator;
		f1.denominator = this.denominator * f.denominator;
		return f1;
	}
	
	public Fraction minus(Fraction f) { // tru
		Fraction f1  = new Fraction();
		f1.numerator = this.numerator * f.denominator -  this.denominator * f.numerator;
		f1.denominator = this.denominator * f.denominator;
		return f1;
	}
	public Fraction multiply(Fraction f) {
		Fraction f1  = new Fraction();
		f1.numerator = this.numerator * f.numerator   ;
		f1.denominator = this.denominator * f.denominator;
		return f1;
	}
	public Fraction divide(Fraction f) {
		Fraction f1  = new Fraction();
		if( f.numerator == 0 ) {
			System.out.println("Error of numerator ");
		}
		else {
			f1.numerator = this.numerator * f.denominator   ;
			f1.denominator = this.denominator * f.numerator;
			
		}
		return f1;
	}
	@Override
	public double value() { // value
		return  1.0*this.numerator / this.denominator  ;
	}
	
	public static void main(String agrs[]) {
		Fraction f1 = new Fraction();
		f1.input();
//		f1.output();
//		Fraction f2 = new Fraction();
//		f2.input();

		System.out.println(f1.value());;
	}
	
}