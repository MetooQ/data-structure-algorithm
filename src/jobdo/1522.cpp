#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	int count;
	struct Node* next;
};

struct Stack {
	struct Node* head;
	struct Node* min;
};

struct Node* createNode();
struct Stack* createStack();
void push(struct Stack* stack, int e);
int pop(struct Stack* stack);
int min(struct Stack* stack);
int isEmpty(struct Stack* stack);

int main()
{
	struct Stack* stack = createStack();
	int n;
	int count;
	int data;
	char opt[3];

	while (scanf("%d", &n) != EOF) {
		for (count = 1; count <= n; ++count) {
			scanf("%s", opt);
			if (opt[0] == 's') {
				scanf("%d", &data);
				push(stack, data);
			} // end if
			else if (opt[0] == 'o') {
				pop(stack);
			} // end else-if

			if (!isEmpty(stack)) {
				printf("%d\n", min(stack));
			} // end if
			else {
				printf("NULL\n");
			} // end else
		
		} // end for
	} // end while

	return 0;
} // end main()

struct Node* createNode()
{
	struct Node* node = (struct Node*)malloc(sizeof(struct Node));
	node->next = NULL;
	node->count = 1;
	return node;
} // end createNode()

struct Stack* createStack()
{
	struct Stack* stack = (struct Stack*)malloc(sizeof(struct Stack));
	stack->head = stack->min = NULL;
	return stack;
} // end createStack()

void push(struct Stack* stack, int e)
{
	struct Node* node = createNode();
	
	node->data =  e;
	node->next = stack->head;
	stack->head = node;

	if (stack->min != NULL) {
		if (e < stack->min->data) {
			node = createNode();
			node->data = e;
			node->next = stack->min;
			stack->min = node;
		} // end if
		else if (e == stack->min->data) {
			++stack->min->count;
		} // end if
	} // end if
	else {
		node = createNode();
		node->data = e;
		stack->min = node;
	} // end else
} // end push()

int pop(struct Stack* stack)
{
	struct Node* temp = stack->head;
	int data = temp->data;

	stack->head = temp->next;
	free(temp);


	if (data == stack->min->data) {
		--stack->min->count;
		if (stack->min->count == 0) {
			temp = stack->min;
			stack->min = temp->next;
			free(temp);
		} // end if
	} // end if

	return data;
} // end pop()

int min(struct Stack* stack)
{
	return stack->min->data;
} // end min()

int isEmpty(struct Stack* stack)
{
	return stack->head == NULL;
} // end isEmpty()

