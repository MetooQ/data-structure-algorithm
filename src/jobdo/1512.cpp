#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct sNode {
	int data;
	struct sNode* next;
};

typedef struct sNode Node;

// 创建一个有头结点的栈
Node* createNode();
int isEmpty(Node* stack);
void push(Node* stack, int e);
int pop(Node* stack);

int main () {
	int n = 0;
	char opt[10];
	int data;
	Node* buffer = createNode();
	Node* container = createNode();

	scanf("%d", &n);
	for ( ; n >= 1; --n) {
		scanf("%s", opt);
		if (strcmp(opt, "PUSH") == 0) {
			scanf("%d", &data);
			push(buffer, data);
		} // end if
		else {
			if (isEmpty(container)) {
				while (!isEmpty(buffer)) {
					data = pop(buffer);
					push(container, data);
				} // end while
			} // end if

			if (isEmpty(container)) {
				data = -1;
			} // end if
			else {
				data = pop(container);
			} // end else

			printf("%d\n", data);
		} // end else
	} // end for

	return 0;
} // end main()

Node* createNode()
{
	Node* head = (Node*)malloc(sizeof(Node));
	head->next = NULL;
	return head;
} // end createNode()

int isEmpty(Node* stack)
{
	return stack->next == NULL;
} // end isEmpty()

void push(Node* stack, int e)
{
	Node* node = createNode();
	node->data = e;
	node->next = stack->next;
	stack->next = node;
} // end push()


int pop(Node* stack) {
	int e = stack->next->data;
	Node* temp = stack->next;
	stack->next = temp->next;
	free(temp);
	temp = NULL;
	return e;
} // end pop()
