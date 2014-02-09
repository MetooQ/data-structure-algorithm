#include <stdio.h>

int main()
{
	int data;
	int start;
	int end;
	int max;
	int s;
	int e;
	int m;
	int i;
	int n;


	scanf("%d", &n);
	while (n != 0) {
		scanf("%d", &data);
		max = m = data;
		start = s = end = e = 0;
		if (m < 0) {
			m = 0;
			s = 1;
		} // end if
		for (i = 1; i < n; ++i) {
			scanf("%d", &data);
			m += data;
			if (m > max) {
				start = s;
				end = i;
				max = m;
			} // end if
			if (m < 0) {
				m = 0;
				s = i + 1;
			} // end if
		} // end for

		printf("%d %d %d\n", max, start, end);

		scanf("%d", &n);
	} // end while

	return 0;
} // end main()
