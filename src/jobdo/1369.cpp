#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// 计算[begin, end)的下一个排列（参考c++ next_permutation），如果
// 到达最后一个排列，返回0
int nextPermutation(char* begin, char* end);
void swap(char* left, char* right); 
void reverse(char* begin, char* end); // reverse [begin, end)
// compare for qsort()
int compare(const void* a, const void* b);


int main()
{
	char input[11];
	int len;

	while (scanf("%s", input) != EOF) {
		len = strlen(input);
		qsort(input, len, sizeof(char), compare);
		
		do {
			printf("%s\n", input);
		} while (nextPermutation(input, input + len));
	} // end while


	
	return 0;
} // end main()

int nextPermutation(char* begin, char* end)
{
	char* next = end;
	char* j;
	char* mid;

	if (begin == end || begin == --next) {
		return 0;
	} // end if

	while (1) {
		j = next;
		if (*--next < *j) {
			mid = end;
			while (*next >= *--mid);
			swap(next, mid);
			reverse(j, end);
			return 1;
		} // end if

		if (next == begin) {
			reverse(begin, end);
			return 0;
		} // end if
	} // end while
} // end nextPermutation()

void swap(char* left, char* right)
{
	char temp;
	temp = *left;
	*left = *right;
	*right = temp;
} // end swap()

void reverse(char* begin, char* end)
{
	--end;
	while (begin < end) {
		swap(begin, end);
		++begin;
		--end;
	} // end while
} // end reverse()

int compare(const void* a, const void* b)
{
	return *((char*)a) - *((char*)b);
} // end compare()

