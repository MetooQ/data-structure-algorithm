#include <stdlib.h>
#include <stdio.h>

int main() {
	char input[10001];
	int map[26];
	int i, len;

	while (scanf("%s", input) != EOF) {
		for (i = 0; i < 26; ++i) {
			map[i] = 0;
		} // end for

		i = 0;
		while (input[i] != '\0') {
			++map[input[i] - 'A'];
			++i;
		} // end while

		i = 0;
		while (input[i] != '\0') {
			if (map[input[i] - 'A'] == 1) {
				break;
			} // end if
			++i;
		} // end while

		if (input[i] == '\0') {
			i = -1;
		}

		printf("%d\n", i);

	} // end while

	return 0;
} // end main()
