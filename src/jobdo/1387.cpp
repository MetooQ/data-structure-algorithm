#include <stdio.h>

unsigned long long fabo(int n);

int main()
{
	int n;

	while (scanf("%d", &n) == 1) {
		printf("%llu\n", fabo(n));
	} // end while

	return 0;
} // end main()

unsigned long long fabo(int n) {
	unsigned long long near = 1;
	unsigned long long far = 0;
	unsigned long long current = 1;
	int i = 1;


	while (i < n) {
		current = near + far;
		far = near;
		near = current;
		++i;
	} // end while

	return current;
} // end fabo
