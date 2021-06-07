package functions;

import array_of_fraction.Fraction;
import array_of_rectangle.Rectangle;

public interface Functions {
	public void input();
	public void output();
	public String toString();
	public void add(Object x);
	public Object get(int index);
	public void set(int index,Object x);
	public void add(Object x, int index);
	public void remove(int index);
	public boolean contains(Object x);
	public int  indexOf(Object x);
	public int  lastIndexO(Object x);
	int  indexOf(int x);

	

}
