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

struct Node* createNode();
struct List* createList();
void add(struct List* list, int e);
void merge(struct List* a, struct List* b, struct List* c);
void printList(struct List* list);
void destroy(struct List* list);

int main()
{
	int sizea, sizeb, data, c;
	struct List* a = createList();
	struct List* b = createList();
	struct List* result = createList();

	while (scanf("%d %d", &sizea, &sizeb) != EOF) {
		for (c = 0; c < sizea; ++c) {
			scanf("%d", &data);
			add(a, data);
		} // end for
		for (c = 0; c < sizeb; ++c) {
			scanf("%d", &data);
			add(b, data);
		} // end for
		merge(a, b, result);
		printList(result);
		destroy(a);
		destroy(b);
		destroy(result);
	} // end while
	return 0;
} // end main()

struct Node* createNode()
{
	struct Node* node = (struct Node*)malloc(sizeof(struct Node));
	node->next = NULL;
	return node;
} // end createNode()

struct List* createList()
{
	struct List* list = (struct List*)malloc(sizeof(struct List));
	list->front = list->rear = NULL;
	return list;
} // end createList()

void add(struct List* list, int e)
{
	struct Node* node = createNode();
	node->data = e;

	if (list->rear != NULL) {
		list->rear->next = node;
		list->rear = node;
	} // end if
	else {
		list->front = list->rear = node;
	} // end else
} // end add()

void merge(struct List* a, struct List* b, struct List* c)
{
	struct Node* currenta = a->front;
	struct Node* currentb = b->front;

	while (currenta != NULL && currentb != NULL) {
		if (currenta->data < currentb->data) {
			add(c, currenta->data);
			currenta = currenta->next;
		} // end if
		else {
			add(c, currentb->data);
			currentb = currentb->next;
		} // end else
	} // end while

	if (currentb != NULL) {
		currenta = currentb;
	} // end while

	while (currenta != NULL) {
		add(c, currenta->data);
		currenta = currenta->next;
	} // end while

} // end merge()

void printList(struct List* list)
{
	struct Node* current = list->front;

	if (current != NULL) {
		printf("%d", current->data);
		current = current->next;
	} // end if
	else {
		printf("NULL\n");
		return;
	} // end else

	while (current != NULL) {
		printf(" %d", current->data);
		current = current->next;
	} // end while
	printf("\n");
} // end printList()

void destroy(struct List* list)
{
	struct Node* current = list->front;
	struct Node* temp = NULL;

	while (current != NULL) {
		temp = current;
		current = current->next;
		free(temp);
	} // end while
	list->front = list->rear = NULL;
} // end destroy()

