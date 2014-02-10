#include <stdio.h>

int min(int a, int b, int c) {
	int r = a < b ? a : b;
	return r < c ? r : c;
} // end min()

int main()
{
	int ugly[1500];
	int i = 1;
	int n;
	int test = 1;
	int next2, next3, next5;
	int c;


	ugly[1] = 1;
	while (scanf("%d", &n) != EOF) {

		if (i < n){
			test = ugly[i];
			while (i < n) {
				for (c = 1; c <= i; ++c) {
					next2 = ugly[c] * 2;
					if (next2 > ugly[i]) {
						break;
					} // end if
				} // end for
				for (c = 1; c <= i; ++c) {
					next3 = ugly[c] * 3;
					if (next3 > ugly[i]) {
						break;
					} // end if
				} // end for
				for (c = 1; c <= i; ++c) {
					next5 = ugly[c] * 5;
					if (next5 > ugly[i]) {
						break;
					} // end if
				} // end for
				ugly[++i] = min(next2, next3, next5);
			} // end while
		} // end if

		printf("%d\n", ugly[n]);

	} // end while
	return 0;
} // end if


