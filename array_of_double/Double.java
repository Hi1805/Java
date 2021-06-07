package array_of_double;

import java.util.Scanner;

import test_array_list.MyNumber;

public class Double  extends MyNumber{
	double i ;
	public double nextDouble() {
		i = (new Scanner(System.in)).nextDouble();
		return  i;
	}
	@Override
	public double value() {
		// TODO Auto-generated method stub
		return i;
	}
	
	
}
