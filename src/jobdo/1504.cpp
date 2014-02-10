#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	int pattern;
};

void fillPattern(struct Node* node);
struct Node* createNode();
int cmp(const void* a, const void* b);

int main()
{
	int n;
	int i;
	int d;
	struct Node* data[100];

	for (i = 0; i < 100; ++i) {
		data[i] = createNode();
	} // end for
	while (scanf("%d", &n) != EOF) {
		for (i = 0; i < n; ++i) {
			scanf("%d", &data[i]->data);
			fillPattern(data[i]);
		} // end for
		qsort(data, n, sizeof(struct Node*), cmp);

		for (i = 0; i < n; ++i) {
			printf("%d", data[i]->data);
		} // end for
		printf("\n");
		
	} // end while

	return 0;
} // end main()


void fillPattern(struct Node* node)
{
	int i = 0;
	int weight = 1;
	int q = node->data;
	int r;
	int pattern = node->data;
	int p[8];
	int n = 0;
	int pos;

	do {
		r = q % 10;
		p[i] = r;
		++i;
		q /= 10;
	} while ( q != 0);
	
	n = i - 1;
	pos = n;
	for (; i <= 7; ++i) {
		pattern *= 10;
		pattern += p[n];
		--n;
		if (n < 0) {
			n = pos;
		} // end if
	} // end for

	node->pattern = pattern;
} // end fillPattern()

struct Node* createNode()
{
	struct Node* node = (struct Node*)malloc(sizeof(struct Node));
	return node;
} // end createNode()


int cmp(const void* a, const void* b)
{
	return (*((struct Node**)a))->pattern - (*((struct Node**)b))->pattern;
} // end cmp()


