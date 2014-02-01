/*

#include <stdio.h>
#include <limits.h>

int digitCount(int n);


int main()
{
	int n;
	int num;

	scanf("%d", &n);



	while (n >= 1) {
		scanf("%d", &num);
		printf("%d\n", digitCount(num));
		--n;
	} // end while

	return 0;
} // end main()

int digitCount(int n)
{
	int digits = 0;

	while (n != 0) {
		n = n & (n - 1);
		++digits;
	} // end while

	return digits;
} // end digitCount()

*/
