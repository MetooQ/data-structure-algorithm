#include <stdio.h>
#include <stdlib.h>


int main()
{
	int n;
	int i;
	int data[100000];
	int max;
	int maxWeight;

	while (scanf("%d", &n) != EOF) {
		scanf("%d", &data[0]);
		max = data[0];
		maxWeight = 1;
		for (i = 1; i < n; ++i) {
			scanf("%d", &data[i]);
			if (data[i] == max) {
				++maxWeight;
			} // end if
			else {
				--maxWeight;
			} // end else

			if (maxWeight == -1) {
				maxWeight = 1;
				max = data[i];
			} // end if
		} // end for

		maxWeight = 0;
		for (i = 0; i < n; ++i) {
			if (data[i] == max) {
				++maxWeight;
			}
		} // end for
		printf("%d\n", maxWeight > n / 2 ? max : -1);
	} // end while
	return 0;
} // end main()

