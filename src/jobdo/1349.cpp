#include <stdio.h>

int firstK(int data[], int k, int length);
int lastK(int data[], int k, int length);

	int data[1000001];

int main()
{
	int n, m, k, i;
	int first, last;


	while ((scanf("%d", &n)) != EOF) {
		for (i = 0; i < n; ++i) {
			scanf("%d", &data[i]);
		} // end for
		scanf("%d", &m);
		while (m >= 1) {
			scanf("%d", &k);
			first = firstK(data, k, n);
			last = lastK(data, k, n);

			if (first > -1 && last > -1) {
				printf("%d\n", last - first + 1);
			} // end if
			else {
				printf("0\n");
			}
			--m;
		} // end while
	} // end while

	return 0;
} // end main()

int firstK(int data[], int k, int length)
{
	int left = 0,
		right = length - 1;
	int mid;
	
	while (left <= right) {
		mid = (left + right) / 2;
		if (data[mid] > k) {
			right = mid - 1;
		} // end if
		else if (data[mid] < k) {
			left = mid + 1;
		} // end else if
		else {
			if ((mid > 0 && data[mid - 1] != k) || mid == 0) {
				return mid;
			} else {
				right = mid - 1;
			} // end else
		} // end else
	} // end while

	return -1;
} // end firstK()

int lastK(int data[], int k, int length)
{
	int left = 0;
	int right = length - 1;
	int mid;

	while (left <= right) {
		mid = (left + right) / 2;

		if (data[mid] > k) {
			right = mid - 1;
		} // end if
		else if (data[mid] < k) {
			left = mid + 1;
		} // end else if
		else {
			if ((mid < length - 1 && data[mid + 1] != k) || mid == length - 1) {
				return mid;
			} // end if
			else {
				left = mid + 1;
			} // end else
		} // end else
	} // end while

	return -1;
} // end lastK()


