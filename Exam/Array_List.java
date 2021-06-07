package Exam;

import java.util.ArrayList;

public class Array_List {
	private ArrayList<Double> arr = new ArrayList<Double>();
	
	double number() {
		double max = arr.get(0);
		double min = arr.get(0);
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i) > max )
				max = arr.get(i);
			if(arr.get(i) < min) {
				min = arr.get(i);
			}
		}
		return max - min ;
	}
}
