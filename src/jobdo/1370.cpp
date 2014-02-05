/*#include <stdio.h>
#include <stdlib.h>

case4 ³¬Ê±

struct Node {
	int data;
	int weight;
};

struct Node* createNode();
int cmp(const void* a, const void* b);

int main()
{
	struct Node* data[100000];
	struct Node* max;
	int count;
	int n;
	int value;
	int i;
	int size;

	while (scanf("%d", &n) != EOF) {
		size = 0;
		for (count = 0; count < n; ++count) {
			scanf("%d", &value);
			for (i = 0; i < size; ++i) {
				if (data[i]->data == value) {
					++data[i]->weight;
					break;
				} // end if
			} // end for
			if (i == size) {
				data[i] = createNode();
				data[i]->data = value;
				++size;
			} // end for
		} // end for

		max = data[0];
		for (i = 1; i < size; ++i) {
			if (data[i]->weight > max->weight) {
				max = data[i];
			} // end if
		} // end for
		printf("%d\n", max->weight > n / 2 ? max->data : -1);
		for (i = 0; i < size; ++i) {
			free(data[i]);
		} // end for
	} // end while

	return 0;
} // end main()


struct Node* createNode()
{
	struct Node* node = (struct Node*)malloc(sizeof(struct Node));
	node->weight = 1;
	return node;
} // end createNode()

int cmp(const void* a, const void* b)
{
//	return ((struct Node*)a)->data - ((struct Node*)b)->data;
	return (*(struct Node**)a)->weight - (*(struct Node**)b)->weight;
} // end cmp()

*/