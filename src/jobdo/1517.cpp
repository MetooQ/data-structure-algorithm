#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	struct Node* next;
};

struct List {
	struct Node* front;
	struct Node* rear;
};

// 有头结点的链表
struct Node* createNode();
struct List* createList();
void add(struct List* list, int e);
struct Node* getLastN(struct List* list, int lastN);
void destroy(struct List* list);

int main()
{
	int n = 0;
	int lastN = 0;
	int data = 0;
	int c = 0;
	struct Node* result = NULL;
	struct List* list = createList();

	while (scanf("%d %d", &n, &lastN) != EOF) {
		for (c = 0; c < n; ++c) {
			scanf("%d", &data);
			add(list, data);
		} // end for
		result = getLastN(list, lastN);
		if (result == NULL) {
			printf("NULL\n");
		} // end if
		else {
			printf("%d\n", result->data);
		} // end else
		destroy(list);
	} // while

	return 0;
} // end main()

struct List* createList()
{
	struct List* list = (struct List*)malloc(sizeof (struct List));
	list->front = list->rear = NULL;
	return list;
} // end createList()


struct Node* createNode()
{
	struct Node* node = (struct Node*)malloc(sizeof(struct Node));
	node->next = NULL;
	return node;
} // end createNode()

void add(struct List* list, int e)
{
	struct Node* temp = createNode();
	temp->data = e;

	if (list->rear != NULL) {
		list->rear->next = temp;
		list->rear = temp;
	} // end if
	else {
		list->front = list->rear = temp;
	} // end else

} // end add()


struct Node* getLastN(struct List* list, int lastN)
{
	struct Node* target = NULL;
	struct Node* current = list->front;

	if (lastN <= 0) {
		return NULL;
	} // end if

	while (current != NULL) {
		--lastN;
		if (lastN < 0) {
			target = target->next;
		} // end if
		else if (lastN == 0) {
			target = list->front;
		} // end else-if

		current = current->next;
	} // end while

	return target;
} // end getLastN()



void destroy(struct List* list)
{
	struct Node* temp;
	
	while (list->front != NULL) {
		temp = list->front;
		list->front = temp->next;

		free(temp);
	} // end while

	list->front = list->rear = NULL;
} // end destroy()


