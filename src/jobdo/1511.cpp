#include <stdio.h>
#include <stdlib.h>

typedef int DataType ;

struct Node {
	DataType data;
	struct Node* next;
};

// 用Node构造有头结点的链表。形成栈
typedef struct Node Stack;

void push(Stack* s, DataType data);
DataType pop(Stack* s);
int isEmpty(Stack* s);
Stack* createStack();

int main()
{
	int d;
	Stack* s = createStack();
	
	scanf("%d", &d);
	while (d != -1) {
		push(s, d);
		scanf("%d", &d);
	} // end while

	while (!isEmpty(s)) {
		printf("%d\n", pop(s));
	} // end while
} // end main()

Stack* createStack()
{
	Stack* s = (Stack*)malloc(sizeof(Stack));
	s->next = NULL;
	return s;
} // end createStack()

void push(Stack* s, DataType data)
{
	Stack* newNode = (Stack*)malloc(sizeof(Stack));
	newNode->data = data;
	newNode->next = s->next;

	s->next = newNode;
} // end push()
DataType pop(Stack* s)
{
	DataType d = s->next->data;
	s->next = s->next->next;
	return d;
} // end pop()
int isEmpty(Stack* s)
{
	return s->next == NULL;
} // end isEmpty()

