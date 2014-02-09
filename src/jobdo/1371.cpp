#include <stdio.h>

void permDown(int data[], int i, int end);
int leftChild(int i);
void swap(int* a, int* b);


int main()
{
	int n;
	int k;
	int i;
	int data[200000];
	int temp;
	int j;

	while (scanf("%d %d", &n, &k) != EOF) {
		for (i = 0; i < k; ++i) {
			scanf("%d", &data[i]);
		} // end for
		for (j = k / 2; j >= 0; --j) {
			permDown(data, j, k);
		} // end for
		for (; i < n; ++i) {
			scanf("%d", &temp);
			if (temp < data[0]) {
				data[0] = temp;
				permDown(data, 0, k);
			} // end if
		} // end for
		for (i = k - 1; i > 0; --i) {
			swap(&data[0], &data[i]);
			permDown(data, 0, i);
		} // end for
		if (k >= 1) {
			printf("%d", data[0]);
		} // end if
		for (i = 1; i < k; ++i) {
			printf(" %d", data[i]);
		} // end for
		printf("\n");
	} // end while
	return 0;
} // end main()

void permDown(int data[], int i, int size)
{
	int child;
	int temp = data[i];
	for (; (child = leftChild(i)) < size; i = child) {
		if (child + 1 < size && data[child] < data[child + 1]) {
			++child;
		} // end if
		if (data[child] > temp) {
			data[i] = data[child];
		} // end if
		else {
			break;
		} // end else
	} // end for
	data[i] = temp;
} // end permDown()

int leftChild(int i)
{
	return 2 * i + 1;
} // end leftChild()

void swap(int* a, int* b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
} // ens swap()

