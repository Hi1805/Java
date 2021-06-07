package Exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Homework {
	
	double difference(ArrayList<Double> arr) {
		return Collections.max(arr) - Collections.min(arr);
	}
	
	public static void main(String agrs[]) {
		Homework h1 = new Homework();
		ArrayList<Double> arrayList = new ArrayList<Double>();
		arrayList.add(-3.2);
		arrayList.add(-2.0);
		
		System.out.println(h1.difference(arrayList));
		
	}
}
