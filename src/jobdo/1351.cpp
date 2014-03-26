#include <stdio.h>

void find(int data[], int* a, int* b, int length);
int firstBit1(int i);
int isPosition1(int n, int pos);

	int data[1000001];

int main()
{
	int n, i;
	int a, b;

	while ((scanf("%d", &n)) != EOF) {
		for (i = 0; i < n; ++i) {
			scanf("%d", &data[i]);
		} // end for

		find(data, &a, &b, n);
		if (a < b) {
			printf("%d %d\n", a, b);
		} else {
			printf("%d %d\n", b, a);
		} // end else
		
	} // end while

	return 0;
} // end main()

void find(int data[], int* a, int* b, int length)
{
	int i, xor = 0;
	int pos;

	for (i = 0; i < length; ++i) {
		xor ^= data[i];
	} // end for

	pos = firstBit1(xor);

	*a = *b = 0;
	for (i = 0; i < length; ++i) {
		if (isPosition1(data[i], pos)) {
			*a ^= data[i];
		} // end if
		else {
			*b ^= data[i];
		} // end else
	} // end for

} // end find()


// 从最低位开始计数(31, 0], 返回第一位为1的位置
int firstBit1(int i)
{
	int pos = 0;
	int mask = 1;
	while (mask) {
		if (i & mask) {
			return pos;
		} // end if
		mask <<= 1;
		++pos;
	}
	return -1;
} // end firstBit1()

int isPosition1(int n, int pos)
{
	return n & (1 << pos);
} // end isPosition1()
