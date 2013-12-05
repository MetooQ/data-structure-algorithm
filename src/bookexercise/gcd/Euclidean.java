
import java.util.Scanner;

public class Euclidean {
	
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
			return euclidean(a, b);
		} // end if
		else {
			return euclidean(b, a);
		}
	}
	
	// a is bigger than b
	private static int euclidean(int a, int b) {
		int r = b;
		
		b = a;
		do {
			a = b;
			b = r;
			r = a % b;
			
		} while (r != 0);
		return b;
	}
}
