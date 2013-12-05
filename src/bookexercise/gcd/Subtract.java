
import java.util.Scanner;

public class Subtract {

	public static void main(String[] args) {
		int n, a, b;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		for (; n >= 1; --n) {
			a = in.nextInt();
			b = in.nextInt();
			System.out.println(gcd(a, b));
		}
	}
	
	public static int gcd(int a, int b) {
		if (a > b) {
			return minus(a, b);
		} else {
			return minus(b, a);
		}
	} // end gcd()
	
	// a > b
	public static int minus(int a, int b) {
		int diff = 0;
		int times = 1;
		
		while ((a % 2 == 0) && (b % 2 == 0)) {
			a /= 2;
			b /= 2;
			times *= 2;
		}
		diff = a;
		do {
			if (diff > b) {
				a = diff;
			} // end if
			else {
				a = b;
				b = diff;
			} // end else
			diff = a - b;
		} while (diff != b);
		return diff * times;
	} 
}
