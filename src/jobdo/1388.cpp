#include <stdio.h>

unsigned long long jump(int n);

int main()
{
	int n = 0;

	while (scanf("%d", &n) == 1) {
		printf("%llu\n", jump(n));
	} // end while

	return 0;
} // end main()

unsigned long long jump(int n) {
	unsigned long long current = 1;
	unsigned long long far = 1;
	unsigned long long near = 1;
	int i = 2;

	for (; i <= n; ++i) {
		current = near + far;
		far = near;
		near = current;
	} // end for

	return current;
} // end fibo()
