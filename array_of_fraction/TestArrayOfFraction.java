package array_of_fraction;

public class TestArrayOfFraction {
	public static void main(String agrs []) {
		ArrayOfFraction arr = new ArrayOfFraction();
		for (int i = 0; i <2; i++) {
			Fraction f  = new Fraction();
			f.input();
			arr.add(f);
		}
		Fraction f2 = new Fraction(2,3);
		System.out.println(arr.contains(f2));
		System.out.println(arr);
	}
}
