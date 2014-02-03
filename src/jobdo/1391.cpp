#include <stdio.h>

#define RIGHT 0
#define LEFT 1
#define UP 2
#define DOWN 3

	int data[1000][1000];

int main()
{

	int m;
	int n;
	int row;
	int col;
	int left;
	int right;
	int top;
	int bottom;
	int i;

	int dir = RIGHT;

	while (scanf("%d %d", &row, &col) != EOF) {
		for (m = 0; m < row; ++m) {
			for (n = 0; n < col; ++n) {
				scanf("%d", &data[m][n]);
			} // end for
		} // end for

		left = 0;
		right = n - 1;
		top = 0;
		bottom = m -1;

		while (left <= right && top <= bottom) {
			if (dir == RIGHT) {
				for (i = left; i <= right; ++i) {
					printf("%d ", data[top][i]);
				} // end for
				++top;
				dir = DOWN;
			} // end if
			else if (dir == DOWN) {
				for (i = top; i <= bottom; ++i) {
					printf("%d ", data[i][right]);
				} // end for
				--right;
				dir = LEFT;
			} // end else-if
			else if (dir == LEFT) {
				for (i = right; i >= left; --i) {
					printf("%d ", data[bottom][i]);
				} // end for
				--bottom;
				dir = UP;
			} // end if
			else if (dir == UP) {
				for (i = bottom; i >= top; --i) {
					printf("%d ", data[i][left]);
				} // end for
				++left;
				dir = RIGHT;
			} // end else-if
		} // end while



		printf("\n");
	} // end while

	return 0;
} // end main()

