#include <stdio.h>

int main()
{
	int in;
	while ((in = getchar()) != EOF) {
		if (in == ' ') {
			printf("%%20");
		} else {
			putchar(in);
		}
	} // while
} // end main()
