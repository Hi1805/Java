package linklist;

import java.util.LinkedList;

/*
In ra gia tri node ke cuoi
Tong cac gia tri trong danh sach lien ket
Dem trong danh sach lien ket bao nhieu so chan
Tinh trung binh cong cac song nguyen to trong danh sach lien ket 
dao 2 node cuoi cho nhau 
dao 2 node dau 
dao node dau va node cuoi 
dao nguoc danh sach lien ket 

*/
public class TestLinkList1 {
	private LinkedList<Integer> list = new LinkedList<Integer>();

	public TestLinkList1(LinkedList<Integer> list) {
		this.list = list;
	}
	public TestLinkList1() {
		
	}
	public Integer nextEnd() {
		return list.get(list.size()-2);
	}
	
	public Integer sum() {// tong cac gia tri
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i);
		}
		return sum;
	}
	
}
