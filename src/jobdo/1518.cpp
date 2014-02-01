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

struct List* createList();
struct Node* createNode();
void add(struct List* list, int e);
void reverse(struct List* list);
void printList(struct List* list);
void destroy(struct List* list);

int main()
{
	int n;
	int c;
	int data;
	struct List* list = createList();

	while (scanf("%d", &n) != EOF) {
		for (c = 0; c < n; ++c) {
			scanf("%d", &data);
			add(list, data);
		} // end for
		reverse(list);
		printList(list);
		destroy(list);
	} // end while
	return 0;
} // end main()

struct List* createList()
{
	struct List* list = (struct List*)malloc(sizeof(struct List));
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
	struct Node* node = createNode();
	node->data = e;

	if (list->rear != NULL) {
		list->rear->next = node;
		list->rear = node;
	} // end if
	else {
		list->rear = list->front = node;
	} // end if

} // end add()

void reverse(struct List* list)
{
	struct Node* current = list->front;
	struct Node* temp = NULL;
	struct Node* head = NULL;

	if (list->front == NULL) {
		return;
	} // end if

	list->rear = current;

	while (current != NULL) {
		temp = current;
		current = current->next;
		temp->next = head;
		head = temp;
	} // end while
	
	list->front = head;
} // end reverse()

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
	struct Node* temp;
	struct Node* current = list->front;

	while (current != NULL) {
		temp = current;
		current = current->next;
		free(temp);
	} // end while

	list->front = list->rear = NULL;
} // end destroy()

