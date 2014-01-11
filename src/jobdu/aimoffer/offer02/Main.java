//package jobdu.aimoffer.offer02;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int[][] data = new int[1000][1000];
		int m, n, t;
		int row, col;
		Scanner input =  new Scanner(System.in);
		
		while (input.hasNextInt()) {
			m = input.nextInt();
			n = input.nextInt();
			t = input.nextInt();
			for (row = 0; row < m; ++row) {
				for (col = 0; col < n; ++col) {
					data[row][col] = input.nextInt();
				}
			} // end for

			if (search(data, 0, m - 1, 0, n - 1, t)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			
		} // end while
		
	} // end main()
	
	public static boolean search(int[][] data, int rowLow, int rowHigh,
			int colLow, int colHigh, int t) {
		
		if (rowLow > rowHigh || colLow > colHigh) {
			return false;
		}
		
		int row = (rowLow + rowHigh) / 2;
		int col = (colLow + colHigh) / 2;
		
		if (data[row][col] < t) {
			return search(data, rowLow, row, col + 1, colHigh, t)
				|| search(data, row + 1, rowHigh, colLow, colHigh, t);
		} else if (data[row][col] > t) {
			return search(data, rowLow, row - 1, colLow, colHigh, t)
				|| search(data, row, rowHigh, colLow, col - 1, t);
		} else {
			return true;
		}
	} // end search()


}















