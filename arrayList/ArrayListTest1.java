package arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//. Tạo một lớp ArrayListTest1 bao gồm các thuộc tính và phương thức sau:
//Thuộc tính: khai báo một đối tượng ArrayList chứa các số nguyên 
//Các phương thức
//a.	Tạo n số nguyên ngẫu nhiên cho đối tượng ArrayList, với n nhập từ bàn phím.
//b.	Tính tổng các phần tử trong đối tượng ArrayList
//c.	Đếm trong đối tượng ArrayList có bao nhiêu giá trị chẵn
//d.	In ra các giá trị chia hết cho 2 hoặc 5 trong đối tượng ArrayList
//e.	Tính trung bình cộng các số nguyên tố trong đối tượng ArrayList
//f.	Xóa các giá trị âm trong đối tượng ArrayList
//g.	Xóa các phần tử trùng nhau (giữ lại duy nhất 1 phần tử) trong đối tượng ArrayList
//h.	Sắp xếp đối tượng ArrayList tăng (giảm) dần
//i.	Giả sử đối tượng ArrayList đã tăng (giảm) dần. Hãy chèn một phần tử element vào đối tượng ArrayList sao cho đối tượng ArrayList vẫn tăng (giảm) dần
//j.	Đưa các số chẳn về trước và các số lẽ về sau trong đối tượng ArrayList
//k.	Tìm dãy con tăng dần dài nhất trong đối tượng ArrayList
//l.	Tìm tổng lớn nhất của 2 phần tử liên tiếp cuối cùng trong đối tượng ArrayList
//m



public class ArrayListTest1 { 
	private ArrayList<Integer> arr = new ArrayList<Integer>();

	public ArrayListTest1() {
		// TODO Auto-generated constructor stub
	}
	public ArrayListTest1(ArrayList<Integer> x){
		arr = x;
	}
	public ArrayListTest1(int cap ){
		arr = new ArrayList<Integer>(cap);
	}
	public void input() {
		int n ;
		System.out.println("Please Enter Number ");
		Scanner kb = new Scanner(System.in);
		n = (new Scanner(System.in)).nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter number "+i);
			arr.add(kb.nextInt());
		}
	}
	public void inputRadom() {
		int n ;
		System.out.println("Please Enter Number ");
		n = (new Scanner(System.in)).nextInt();
		for (int i = 0; i < n; i++) {
	;
			arr.add((int)(Math.random()*100));
		}
	}
	
	public long sum() {
		long sum = 0;
		for (int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
		}
		return sum;
	}
	
	public int countEventNumber() {
		int count = 0;
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i)%2 == 0)
				count++;
		}
		return count;
	}
	
	public void Print() { // in ra chia het cho 2 va 5
		for (int i = 0; i <arr.size(); i++) {
			if(arr.get(i)%2 == 0 || arr.get(i)%5 == 0)
				System.out.println(arr.get(i));
		}
	}
	public boolean isPrime(int x) {
		if(x<2)
			return false;	
		for (int i = 2; i < Math.sqrt(x); i++) {
			if(x%2 == 0)
				return false;
		}
		return true;
	}
	public double averagePrime() {
		double sum = 0;
		for (int i = 0; i < arr.size(); i++) {
			if(isPrime(arr.get(i))) {
				sum+=arr.get(i);
			}
		}
		return sum;
	}
	
	public 	void  removeNegative () { // xoa cac so am
		for (int i = 0; i <arr.size(); i++) {
			if(arr.get(i)<0) {
				arr.remove(i);
			}
		}
	}
	public void removeElementSame() {// xoa cac phan tu giong nhau
		for (int i = 0; i < arr.size()-1; i++) {
			for (int j = i+1; j < arr.size();) {
				if(arr.get(i) == arr.get(j)) { 
					arr.remove(j);
				}
				else j++;
			}
		}	
	}
	public void sortDescending () {
		arr.sort((a,b)->a-b);
	}
	public void sortAcending() {
		
		arr.sort((a,b)->a+b);
	}
	public String toString() {
		return arr.toString(); // toString la cua lop cha cua Arraylist
	}
	public void insertElement (int element) { // chen vao  mang tang dan	
		arr.add(element);
		arr.sort((a,b)->a+b);
	}
	
	
	public void swap(int i , int j) {
		int temp = arr.get(i);
		int temp2 = arr.get(j);
		arr.set(j, temp);
		arr.set(i, temp2);
	}
	
	
	public void sortEvenAndOdd() { // 
		int index = 0;
		for (int i = 0 ; i<arr.size() ; i++) {
	
				if(arr.get(i)%2 == 0) {
				// 0 5 8 2 3 
					
					swap(i, index);
					index++;
				}	
		}
	}
	public ArrayList<Integer>  findListMax2() { // tim day con  dai nhat
	
			int dem1 = 1;
			int dem2 = 0;
			int index = 0;
			for(int i = 0; i < arr.size() - 1; i++){
				if(arr.get(i+1) >  arr.get(i)){
					dem1++;
				} // 1 2 3 4
				else
				{
					if(dem1>dem2){
						dem2 = dem1;
						index = i;
					}
					dem1 = 1;
				}
				
			}
			int count = dem1 > dem2 ? dem1 : dem2  ;
//			System.out.println("Index : "+index);
//			System.out.println("count : "+count);
			ArrayList<Integer> newArrayList = new ArrayList<Integer>();
			int index2 = 0;
			index2 = index - count + 1;
			for (int i = 0; i < count; i++) { // count = 5
				newArrayList.add(i,arr.get(index2));
				index2 ++ ;
			}
		return newArrayList;
	}
	
public ArrayList<Integer>  findListMax() { // tim day dai nhat
		
		int dem1 = 1;
		int dem2 = 0;
		int index = 0;
		
		for(int i = 0; i < arr.size() - 1; i++){
			if(arr.get(i+1) >  arr.get(i)){
				dem1++; //1 2 3 4 1 2 3
			}
			else
			{
				if(dem1>dem2){
					dem2 = dem1;
					index = i - dem1 +1;
				}
				dem1 = 1;
			}
		}
		int count = 0  ;
		if(dem1 > dem2) {
			count = dem1;
			index = arr.size() - count;
		}else {
			count = dem2;
		}
		
		ArrayList<Integer> newArrayList = new ArrayList<Integer>();
		
		for (int i = 0; i < count; i++) { 
			newArrayList.add(i,arr.get(index+i));
		}
		
	return newArrayList;
}
	public int maxSum() { // tim tong lon nhat cua 2 phan tu lon nhat
		int max = 0;
		for (int i = 0; i < arr.size(); i++) {
			if(max <= arr.get(i) + arr.get(i+1))
				max = arr.get(i) + arr.get(i+1);
		}
		return max;
	}
	
	public  static void main(String agrs[]) {
		ArrayListTest1 a1 = new ArrayListTest1();
		a1.input();
//		a1.inputRadom();
//		System.out.println(a1);
//		a1.removeElementSame();
//		System.out.println(a1);// to String cua object
//		a1.sortDescending();
		
//		a1.insertElement(4);
//		System.out.println(a1);
		
		//a1.sortEvenAndOdd();
		System.out.println(a1.findListMax());
		System.out.println(a1);
	}
}
