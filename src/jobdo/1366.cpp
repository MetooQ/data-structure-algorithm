#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	struct Node* next;
};

struct Stack {
	struct Node* head;
};

struct Node* createNode();
struct Stack* createStack();
void push(struct Stack* stack, int e);
int pop(struct Stack* stack);
int isEmpty(struct Stack* stack);
int peek(struct Stack* stack);

int main()
{
	int in[100000];
	int out[100000];
	int n;
	int inIndex;
	int outIndex;
	struct Stack* stack = createStack();
	int isError;

	while (scanf("%d", &n) != EOF) {
		for (inIndex = 0; inIndex < n; ++inIndex) {
			scanf("%d", &in[inIndex]);
		} // end for
		for (outIndex = 0; outIndex < n; ++outIndex) {
			scanf("%d", &out[outIndex]);
		} // end for

		isError = 0;
		inIndex = 0;
		for (outIndex = 0; outIndex < n && !isError; ++outIndex) {
			if (!isEmpty(stack) && peek(stack) == out[outIndex]) {
				pop(stack);
			} // end if
			else {
				while (inIndex < n && in[inIndex] != out[outIndex]) {
					push(stack, in[inIndex++]);
				} // end if
				
				if (inIndex == n) {
					isError = 1;
				} // end if
				else {
					++inIndex;
				} // end else
			} // end if
		} // end for

		if (isError) {
			printf("No\n");
		} // end if
		else {
			printf("Yes\n");
		} // end else
	} // end while

	return 0;
} // end main()

struct Node* createNode()
{
	struct Node* node = (struct Node*)malloc(sizeof (struct Node));
	node->next = NULL;
	return node;
} // end createNode()

struct Stack* createStack()
{
	struct Stack* stack = (struct Stack*)malloc(sizeof(struct Stack));
	stack->head = NULL;
	return stack;
} // end createStack()

void push(struct Stack* stack, int e)
{
	struct Node* node = createNode();
	node->next = stack->head;
	node->data = e;
	stack->head = node;
} // end push()

int pop(struct Stack* stack)
{
	struct Node* temp = stack->head;
	int data = temp->data;

	stack->head = temp->next;

	free(temp);

	return data;
} // end pop()

int isEmpty(struct Stack* stack)
{
	return stack->head == NULL;
} // end isEmpty()

int peek(struct Stack* stack)
{
	return stack->head->data;
} // end peek()

