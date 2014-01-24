#include <stdio.h>

unsigned long long fibo(int n);

int main()
{
	int n;

	while (scanf("%d", &n) == 1) {
		printf("%llu\n", fibo(n));
	} // end while

	return 0;
} // end main()

unsigned long long fibo(int n)
{
	unsigned long long current = 1;
	unsigned long long near = 1;
	unsigned long long far = 1;
	int i = 2;

	for ( ; i <= n; ++i) {
		current = far + near;
		far = near;
		near = current;
	} // end for

	return current;
} // end fibo()
