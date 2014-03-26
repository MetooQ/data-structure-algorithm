#include <stdio.h>

int mergesort(int data[], int temp[], int left, int right);
int merge(int data[], int temp[], int leftBegin, int rightBegin, int rightEnd);

int main() 
{
	int in[100001];
	int temp[100001];
	int i, len;

	while (scanf("%d", &len) != EOF) {
		for (i = 0; i < len; ++i) {
			scanf("%d", &in[i]);
		} // end for
		printf("%d\n", mergesort(in, temp, 0, len - 1));
	} // end while()

	return 0;
} // end main()


int mergesort(int data[], int temp[], int left, int right)
{
	int middle = (left + right) / 2;
	int count = 0;

	if (left < right) {
		count += mergesort(data, temp, left, middle);
		count += mergesort(data, temp, middle + 1, right);
		count += merge(data, temp, left, middle + 1, right);
	} // end if

	return count;
} // end mergesort()

int merge(int data[], int temp[], int leftBegin, int rightBegin, int rightEnd)
{
	int left = leftBegin,
		leftEnd = rightBegin - 1,
		right = rightBegin,
		count = 0,
		i = leftBegin;

	while (left <= leftEnd && right <= rightEnd) {
		if (data[left] > data[right]) {
			temp[i++] = data[left++];
			count += rightEnd - right + 1;
		} // end if
		else {
			temp[i++] = data[right++];
		} // end else
	} // end while

	while (left <= leftEnd) {
		temp[i++] = data[left++];
	} // end while
	while (right <= rightEnd) {
		temp[i++] = data[right++];
	} // end while

	while (leftBegin <= rightEnd) {
		data[leftBegin] = temp[leftBegin];
		++leftBegin;
	} // end while



	return count;
} // end merge()


