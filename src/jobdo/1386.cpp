#include <stdio.h>
	int data[1000000];
int main()
{
	int n = 0;
	int i = 0;


	while (scanf("%d", &n) == 1) {
		for (i = 0; i < n; ++i) {
			scanf("%d", &data[i]);
		} // end for

		for (i = 0; i < n - 1; ++i) {
			if (data[i] > data[i + 1]) {
				break;
			} // end if
		} // end for

		if (i != n - 1) {
			printf("%d\n", data[i + 1]);
		} else {
			printf("%d\n", data[0]);
		}
		

	} // end while
	return 0;
} // end main()
