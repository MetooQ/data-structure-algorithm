
import java.util.Scanner;

public class DP {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = 0, length;
		int[] data;
		
		n = input.nextInt();
		
		while (n > 0) {
			length = input.nextInt();
			data = new int[length];
			for (int i = 0; i < length; ++i) {
				data[i] = input.nextInt();
			} // end for
			System.out.format("%d%n", minsubsum(data));
			
			--n;

		} // end while
		
		
	}
	
	public static int minsubsum(int[] data) {
		int min = Integer.MAX_VALUE, current = 0;
		for (int i = 0; i < data.length; ++i) {
			current += data[i];
			if (current < min) {
				min = current;
			} // end if
			if (current > 0) {
				current = 0;
			} // end if
		} // end for
		return min;
	} // end minsubsum()
}












