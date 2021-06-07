package array_of_integer;

import java.util.Scanner;

import test_array_list.MyNumber;

public class Integer  extends MyNumber{
	int i ;
	public int nextInt() {
		i = (new Scanner(System.in)).nextInt();
		return  i;
	}
	@Override
	public double value() {
		// TODO Auto-generated method stub
		return i;
	}
	
}
