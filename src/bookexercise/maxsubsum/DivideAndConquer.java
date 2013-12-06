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
			System.out.format("%d%n", maxsubsum(data, 0, length - 1));
			
			--n;

		} // end while
		
		
	}
	
	public static int maxsubsum(int[] data, int left, int right) {
		if (left == right) {
			return data[left];
		} // end if
		
		int center = (left + right) / 2;
		int maxLeft = maxsubsum(data, left, center);
		int maxRight = maxsubsum(data, center + 1, right);
		
		int leftBounder = 0, maxLeftBounder = Integer.MIN_VALUE;
		for (int i = center; i >= left; --i) {
			leftBounder += data[i];
			if (leftBounder > maxLeftBounder) {
				maxLeftBounder = leftBounder;
			}
		} // end for
		
		int rightBounder = 0, maxRightBounder = Integer.MIN_VALUE;
		for (int i = center + 1; i <= right; ++i) {
			rightBounder += data[i];
			if (rightBounder > maxRightBounder) {
				maxRightBounder = rightBounder;
			} // end if
		} // end for
		
		return Math.max(maxRightBounder + maxLeftBounder, 
				Math.max(maxLeft, maxRight));
	}

}
