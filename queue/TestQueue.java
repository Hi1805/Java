package queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;





public class TestQueue {
	static Queue<Integer> q  = new LinkedList<Integer>();
	static int[] a = {2, 12, 213, 45,-3 ,68,94,367,9251,1068,1002,10,-56883};
	public static int max() { // tim so lon nhat 
		
		int max = Math.abs(a[0]);
		for (int i = 0; i < a.length; i++) {
			q.add(a[i]);// add cac phan tu vao Q 
			if( Math.abs(a[i])> max )
				max =Math.abs(a[i]);
		}
		return max;
	}
	public static int countNumber(int max) { // dem xem co bao nhieu chu so
		int count = 0;
		while (max > 0) {
			count++;
			max = max/10;	
		}
		return count;
	}
	public static void  sortAcessding () {
		int count = countNumber(max());
		Queue<Integer>[]  qq = new LinkedList[20];
		
		for (int i = 0; i < qq.length; i++) {
			qq[i] = new LinkedList<Integer>();
		}
		int d = 1;
		for (int i = 0; i < count; i++) {
			while (!q.isEmpty()) {
				int temp = q.remove();
				int vt;
				if(temp >= 0 ) {
					vt = (temp/d)%10;
				}
				else vt = (Math.abs(temp)/d)%10 + 10;
				
				qq[vt].add(temp);
			}
			
			for (int j = qq.length - 1; j >= 10; j--) {
				while (!qq[j].isEmpty()) {
					q.add(qq[j].remove());		
				}
			}
			for (int j = 0; j < 10; j++) {
				while (!qq[j].isEmpty()) {
					q.add(qq[j].remove());
				}
			}
			d = d*10;
		}
		for (int i = 0;  !q.isEmpty(); i++) {
				a[i] = q.remove();
		}
		}
	
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s = s + a[i] + " ";
		}
		return s;
	}
	public static void main(String agrs[]) {
		TestQueue t1 = new TestQueue();
		sortAcessding();
		System.out.println(t1);
	
	}
}
