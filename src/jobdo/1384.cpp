#include <stdio.h>

int data[1000][1000];

int main() {
	int m, n, key, col, row;
	int isExist = 0;

	while (scanf("%d%d%d", &m, &n, &key) == 3) {
		for (row = 0; row < m; ++row) {
			for (col = 0; col < n; ++col) {
				scanf("%d", &data[row][col]);
			} // end for
		} // end for

		isExist = 0;
		if (key < data[0][0] || data[row - 1][col - 1] < key) {
			isExist = 0;
		} // end if
		else {
			row = 0;
			col = n - 1;
			while (row < m && col < n) {
				if (data[row][col] < key) {
					++row;
				} // end if
				else if (data[row][col] > key) {
					--col;
				} // end else if
				else {
					isExist = 1;
					break;
				} // end else
			} // end while

		} // end else

		if (isExist == 1) {
				printf("Yes\n");
		} // end if
		else {
			printf("No\n");
		} // end else

	} // end while


} // end main()

