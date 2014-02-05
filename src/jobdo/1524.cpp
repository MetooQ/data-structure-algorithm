#include <stdio.h>
#include <stdlib.h>

struct Node{
	int data;
	struct Node* next;
	struct Node* any;
};

struct List{
	struct Node* front;
	struct Node* rear;
};

struct Node* createNode();
struct List* createList();
void printList(struct List* list);
void destroy(struct List* list);

int main()
{
	struct Node* data[1002];
	int n;
	int count;
	int any;
	struct List* list = createList();

	while (scanf("%d", &n) != EOF) {
		for (count = 1; count <= n; ++count) {
			data[count] = createNode();
			scanf("%d", &data[count]->data);
		} // end for

		for (count = 1; count <= n; ++count) {
			data[count]->next = data[count + 1];
			scanf("%d", &any);
			if (any != 0) {
				data[count]->any = data[any];
			} // end if
		} // end for
		data[n]->next = NULL;

		list->front = data[1];
		printList(list);
		destroy(list);

	} // end while

	return 0;
} // end main()

struct Node* createNode()
{
	struct Node* node = (struct Node*)malloc(sizeof (struct Node));
	node->next = node->any = NULL;
	return node;
} // end createNode()

struct List* createList()
{
	struct List* list = (struct List*)malloc(sizeof(struct List));
	list->front = list->rear = NULL;
	return list;
} // end createList()

void printList(struct List* list)
{
	struct Node* current = list->front;

	while (current != NULL) {
		printf("%d %d\n", current->data, current->any == NULL ? 0 : current->any->data);
		current = current->next;
	} // end while
} // end printList()

void destroy(struct List* list)
{
	struct Node* temp;
	struct Node* current = list->front;

	while (current != NULL) {
		temp = current;
		current = current->next;
		free(temp);
	} // end while

	list->front = list->rear = NULL;
} // end destroy()

