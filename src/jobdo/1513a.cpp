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
	unsigned int flag = 1;
	
	while (flag) {
		if (n & flag) {
			++digits;
		} // end if
		
		flag <<= 1;
	} // end while

	return digits;
} // end digitCount()


