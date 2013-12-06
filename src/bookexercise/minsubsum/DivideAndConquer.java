
import java.util.Scanner;

public class DivideAndConquer {
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
			System.out.format("%d%n", minsubsum(data, 0, length - 1));
			
			--n;

		} // end while
		
		
	} // end main()
	
	public static int minsubsum(int[] data, int left, int right) {
		
		if (left == right) {
			return data[left];
		}
		
		int center = (left + right) / 2;
		
		int minLeft = minsubsum(data, left, center);
		int minRight = minsubsum(data, center + 1, right);
		
		int minLeftBorder = Integer.MAX_VALUE, leftSum = 0;
		for (int i = center; i >= left; --i) {
			leftSum += data[i];
			if (leftSum < minLeftBorder) {
				minLeftBorder = leftSum;
			} // end if
		} // end for
		
		int minRightBorder = Integer.MAX_VALUE, rightSum = 0;
		for (int i = center + 1; i <= right; ++i) {
			rightSum += data[i];
			if (rightSum < minRightBorder) {
				minRightBorder = rightSum;
			} // end if
		} // end for
		
		return Math.min(minLeftBorder + minRightBorder, 
				Math.min(minLeft, minRight));
		
	} // end minsubsum()
}




















