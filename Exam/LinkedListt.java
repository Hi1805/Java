package Exam;

import java.util.LinkedList;


public class LinkedListt {
	LinkedList<Integer> l1 = new LinkedList<Integer>();
	
	public void insertElement(int element) {
		int length = l1.size();								//            -40 
		while ((length-1)>= 0 &&l1.get(length-1) > element  ) {// 10 10 15 
			length--;
		}
		l1.add(length, element);
	}
	
	public boolean 	check() {
		if(l1.size()<3)
			return false;
				
		for (int i = 1; i < l1.size()-1; i=i+2) {
			if((l1.get(i-1) >= l1.get(i) &&  l1.get(i) >= l1.get(i+1))|| (l1.get(i-1) <= l1.get(i) &&  l1.get(i) <= l1.get(i+1))) {
					return false;
			}
		}
		return true;
	}
	public static void main(String agrs[]) {// myo
		LinkedListt list = new LinkedListt();
//		list.l1.add(4);// 	4,1,3,2,8,5,6
//		list.l1.add(1);//	1,4,2,7,3,8
//		list.l1.add(3);
//		list.l1.add(2);
//		list.l1.add(8);
//		list.l1.add(5);
//		list.l1.add(6);
		list.l1.add(10);// 	4,1,3,2,8,5,6
		list.l1.add(4);
		list.l1.add(8);	//	1,4,2,7,3,8
		list.l1.add(5);
		list.l1.add(6);
		list.l1.add(3);
		list.l1.add(8);
//		list.insertElement(40);
		System.out.println(list.check());// true 
		System.out.println(list.l1);
		
	}
}
