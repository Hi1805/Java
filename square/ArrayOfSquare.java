package square;

import java.util.Scanner;

public class ArrayOfSquare { // mang hinh vuong
	Square a[];
	int n ;									// a[i] == x // do dai canh cung bang nhau no ra false, k bang nhau ?
	//output,toString,addIndex,add,indexOf,LastIndexOf,Contains,remove  =>Contains// a[i].dientich = x.dientich
	//constructor => ham khoi tao 
	// 2 ham khoi tao : ham khoi tao, va ham khoi tao co doi
	public ArrayOfSquare() {
		a = new Square [3];
		// mang nay do dai la 3 , java do dai mang k the thay doi
		n = 0;
	}
	// overloading
	public ArrayOfSquare(int soLuongBoNho ) { // ham khoi tao co doi so  slbn = 5
		a = new Square[soLuongBoNho];
		n = 0;
	}
	
	public void add(Square square ) { // them 1 hinh vuong vao cuoi mang
		if(n == a.length ) { // n  =3   n = 6
			Square[] b = new Square[a.length * 2];
			for (int i = 0; i < a.length; i++) {
			     	b[i] = a[i];
			}
			a = b;
		}
		a[n] = square;
		n ++;// n = n + 1;
	}
	public void add(int index , Square s ) { // them 1 hinh vuong vao 1 vi tri
		if (index  < 0 || index > n) {
			System.out.println(" Loi vi tri ");
		}
		else { 
			if ( n == a.length ) { // kiem tra mang da day hay chua ?
				Square[] b = new Square[a.length * 2];
				for (int i = 0; i < a.length; i++) {
				     	b[i] = a[i];
				}
				a = b; // bien thanh mang chua day
			}
			// 
			for (int i = n; i > index ; i-- ) {
					a[i] = a[i-1]; // doi mang lui 1 2 3 4 5 index = 2 . 1 2  index  3 4 5
			}
//			nó sẽ xảy ra trường hợp i = index ,tức là nó sẽ trừa ra 1 vị trí là index
			a[index] = s;
			n++;
		}
	}
	public int lastIndexOf (Square s) { // co nghia la tim vi tri cuoi cung s co trong mang
		// 0 1 2 3 6 6  , tim vi tri cua gia tri 6 thi no se la 5
		for (int i = n-1; i>=0; i--) {
			if (s.dientich() ==  a[i].dientich()) {
				return i;
			}
		}
		return -1;
	}
	public void input() {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap n : ");
		n = ip.nextInt();
		a  = new Square[n]; // NULL || NULL ..
		for (int i = 0; i < n; i++) {
			System.out.println("Enter hinh vuong a["+i+"]");
			a[i] = new Square();
			a[i].input();
		}
	}
	public void output() {
	//	Square a[] = {hv1,hv2,hv3,hv1,hv1}; // a[i] luc nay 1 doi tuong , chua dia chi
		for (int i = 0; i < n; i++) {
			System.out.println("a["+i+"] :");
			a[i].output();
			System.out.println();
		}	
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < n; i++) {
			s = s + a[i].toString() + " "; // a[i] la 1 hinh vuong
		}
		return s;	
		
}
		
	public static void main (String agrs []) {
		ArrayOfSquare arr = new ArrayOfSquare();
		arr.input();
		Square s1 = new Square();
		s1.input();
		arr.add(s1);// them vi tri cuoi mang
		arr.add(2, s1);
		arr.output();
		// a = 4      a = 4
		// a = 2 , b  = 3  || a = 3,b =2  w l 
	//	if(a[i].a == hcn.a )
	}
}
