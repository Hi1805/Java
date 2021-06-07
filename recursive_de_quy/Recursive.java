package recursive_de_quy;

import java.net.Socket;

public class Recursive {
	static double  twoPow(int n ) {
		
		if(n == 0) {
			return 1;
		}
		if(n > 0)
			return 2*twoPow(n-1);
		return 1/(2*twoPow(Math.abs(n) - 1));
	}
	static int greatestCommonDivisor(int a, int b) {//uoc chung lon
		a = Math.abs(a);
		b = Math.abs(b);
		if(a == b)
			return a;
		if(a > b)
			return greatestCommonDivisor(a - b, b);
		return greatestCommonDivisor(a, b-a);
		
	}
	static double  division(int a , int b) {// a chia b
		if(a * b < 0) {
			return -1 - division(Math.abs(a) - Math.abs(b), Math.abs(b));
		}
		a = Math.abs(a);
		b = Math.abs(b);
		if(b > a) {
			return 0;
		}
		if(a == b) 
			return 1;
		return 1 + division(a - b, b) ;
	}
	static int surplus(int a , int b) { // so du a chia b 
		b =  Math.abs(b);
		if(a == b )
			return 0;
		if(Math.abs(a)  < b ) 
			return a;
		if(a < 0) {
			return surplus(a + b, b);
		}
		return surplus(a - b, b);
	}
	public static String reverse(String str) {
	    if ((null == str) || (str.length() <= 1)) {
	        return str;
	    }
	    return reverse(str.substring(1)) + str.charAt(0);
	}
	public static void reverse2(int n) {
		if(n > 0 ) {
			reverse2(n/10);
			System.out.println(n%10);
		}
		
	}
	public static int  fibonacci(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	public  static String fibonacciLine(int n) {
		if( n == 0)
			return "";
		return fibonacciLine( n- 1) + fibonacci(n) + " ";
	}
	public static void decToBin(int n , int k) {
		if(n > 0) {
			decToBin(n/k, k);
			if(n % k < 10)
				System.out.print(n%k + " ");
			else 
				System.out.print((char)(n%k + 55) + " ");
		}
	}
	public static void  main(String agrs[]) {
		System.out.println(greatestCommonDivisor(-255, 25));
//		System.out.println(twoPow(-1));
		//System.out.println(division(-100, 2));
//		System.out.println("567".substring(1));
		//System.out.println(surplus(8,5));
//		System.out.println(fibonacciLine(5));
//		System.out.println(reverse("2336"));
//		decToBin(781, 16);
//	reverse2("123");
	}
	
	
}
