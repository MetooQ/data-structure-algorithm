

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
			System.out.format("%d%n", maxsubsum(data));
			
			--n;

		} // end while
		

	}

	public static int maxsubsum(int[] data) {
		int maxSum = Integer.MIN_VALUE,
			currentSum = 0;
		
		for (int i = 0; i < data.length; ++i) {
			currentSum += data[i];
			if (currentSum > maxSum) {
				maxSum = currentSum;
			} // end if
			
			if (currentSum < 0) {
				currentSum = 0;
			}
		} // end for
				
		return maxSum;
	}
}
