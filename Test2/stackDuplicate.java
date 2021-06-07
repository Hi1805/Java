package Test2;

import Test2.*;

public class stackDuplicate<E> {
	void reverse(int a[]){
		for(int i = 0 ; i <= a.length/2; i ++ ){
		 	int x = a[i];
			a[i] = a[a.length - i - 1];
			 a[a.length - i - 1] = x;
		}
	}
	void dp(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	int max (int a[][]) {
		int max = a[0][0];
		System.out.println(a.length);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(max < a[i][j]) {
					max = a[i][j];
				}
			}
		}
		return max;
	}
	public static void main(String agrs[]) {
		stackDuplicate<Integer> st1 = new stackDuplicate<Integer>();
		int a[] = {1,2,3,4,5,6,7,8,9};
//		st1.reverse(a);	
//		st1.dp(a);
		int b[][] = {{1,2,3},{4,5,6}};
		System.out.println(st1.max(b));
		System.out.println(b.length);
	}
}
