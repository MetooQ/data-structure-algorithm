#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	struct Node* next;
};

struct Queue {
	struct Node* front;
	struct Node* rear;
};

// 有头结点的队列
struct Node* createNode();
struct Queue* createQueue();
void enqueue(struct Queue* q, int e);
int dequeue(struct Queue* q);
int isEmpty(struct Queue* q);


int main()
{
	int n;
	int c = 0;
	int data;
	int isFirst = 1;
	struct Queue* odd = createQueue();
	struct Queue* even = createQueue();

	scanf("%d", &n);

	for (c = 0; c < n; ++c) {
		scanf("%d", &data);
		if (data % 2 == 1) {
			enqueue(odd, data);
		} // end if
		else {
			enqueue(even, data);
		} // end else
	} // end for


	if (!isEmpty(odd)) {
		printf("%d", dequeue(odd));
		isFirst = 0;
	} // end if

	while (!isEmpty(odd)) {
		printf(" %d", dequeue(odd));
	} // end while

	if (isFirst) {
		if (!isEmpty(even)) {
			printf(" %d", dequeue(even));
		} // end if	
	} // end if

	while (!isEmpty(even)) {
		printf(" %d", dequeue(even));
	} // end while

	return 0;
} // end main()


struct Queue* createQueue()
{
	struct Queue* q = (struct Queue*)malloc(sizeof(struct Queue));
	q->front = q->rear = NULL;
	return q;
} // end createQueue()


struct Node* createNode()
{
	struct Node* node = (struct Node*)malloc(sizeof (struct Node));
	node->next = NULL;
	return node;
} // end createNode()

void enqueue(struct Queue* q, int e)
{
	struct Node* temp = createNode();
	temp->data = e;
	
	if (q->rear == NULL) {
		q->front = q->rear = temp;
	} // end if
	else {
		q->rear->next = temp;
		q->rear = temp;
	} // end else

} // end enqueue()


int dequeue(struct Queue* q)
{
	int data = 0;
	struct Node* temp = q->front;

	q->front = q->front->next;

	if (q->front == NULL) {
		q->rear = NULL;
	} // end if
	
	data = temp->data;
	free(temp);

	return data;
} // end dequeue()


int isEmpty(struct Queue* q)
{
	return q->front == NULL;
} // end isEmpty()


