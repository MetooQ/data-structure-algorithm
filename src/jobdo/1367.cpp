#include <stdio.h>


int isPostOrder(int data[], int start, int end);

int main()
{
	int data[10000];
	int n;
	int count;

	while (scanf("%d", &n) != EOF) {
		for (count = 0; count < n; ++count) {
			scanf("%d", &data[count]);
		} // end for

		if (isPostOrder(data, 0, n -1)) {
			printf("Yes\n");
		} // end if
		else {
			printf("No\n");
		} // end else
	} // end while

	return 0;
} // end main()


int isPostOrder(int data[], int start, int end)
{
	int isValid = 1;
	int leftStatus = 1;
	int rightStatus = 1;
	int count;
	int rightBegin;

	if (start >= end) {
		return 1;
	} // end if

	for (count = start; count < end; ++count) {
		if (data[count] > data[end]) {
			rightBegin = count;
			break;
		} // end if
	} // end for

	for (; count < end; ++count) {
		if (data[count] < data[end]) {
			return 0;
		} // end if
	} // end if

	return isPostOrder(data, start, rightBegin -1) && 
		isPostOrder(data, rightBegin, end - 1);
} // end isPostOrder()

