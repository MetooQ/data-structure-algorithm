#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	struct Node* left;
	struct Node* right;
};

struct Tree {
	struct Node* root;
};

struct qNode {
	struct Node* data;
	struct qNode* next;
};

struct Queue {
	struct qNode* front;
	struct qNode* rear;
};

struct qNode* createqNode();
struct Queue* createQueue();
void enqueue(struct Queue* q, struct Node* data);
struct Node* dequeue(struct Queue* q);
int isQueueEmpty(struct Queue* q);

struct Node* createNode();
struct Tree* createTree();
struct Tree* constructTree(int n);
int isSubTree(struct Tree* t, struct Tree* sub);
void destroy(struct Tree* t);
void destroyNode(struct Node* node);

int treeMatch(struct Node* tree, struct Node* sub);

int main()
{
	int m;
	int n;
	struct Tree* tree = NULL;
	struct Tree* sub = NULL;

	while (scanf("%d %d", &m, &n) != EOF) {
		tree = constructTree(m);
		sub = constructTree(n);

		if (isSubTree(tree, sub)) {
			printf("YES\n");
		} // end if
		else {
			printf("NO\n");
		} // end else

		destroy(tree);
		destroy(sub);
	} // end while


	return 0;
} // end main()

int treeMatch(struct Node* tree, struct Node* sub)
{
	int matchLeft = 1;
	int matchRight = 1;

	if (sub->left != NULL) {
		matchLeft = tree->left == NULL ? 0 : treeMatch(tree->left, sub->left);
	} // end if

	if (sub->right != NULL) {
		matchRight = tree->right == NULL ? 0 : treeMatch(tree->right, sub->right);
	} // end if

	return matchLeft && matchRight && tree->data == sub->data;
} // end treeMatch()

struct Node* createNode()
{
	struct Node* node = (struct Node*)malloc(sizeof(struct Node));
	node->left = node->right = NULL;
	return node;
} // end createNode()

struct Tree* createTree()
{
	struct Tree* tree = (struct Tree*)malloc(sizeof(struct Tree));
	tree->root = NULL;
	return tree;
} // end createTree()

struct Tree* constructTree(int n)
{
	struct Tree* tree = createTree();
	struct Node* nodes[1000];
	struct Node* node;
	int i;
	int data;
	int sonAmount;
	int sonCount;
	int sonIndex;

	for (i = 1; i <= n; ++i) {
		scanf("%d", &data);
		node = createNode();
		node->data = data;
		nodes[i] = node;
	} // end for

	for (i = 1; i <= n; ++i) {
		scanf("%d", &sonAmount);
		if (sonAmount == 2) {
			scanf("%d", &sonIndex);
			nodes[i]->left = nodes[sonIndex];
			scanf("%d", &sonIndex);
			nodes[i]->right = nodes[sonIndex];
		} // end if
	} // end for

	tree->root = nodes[1];

	return tree;
} // end constructTree()

int isSubTree(struct Tree* t, struct Tree* sub)
{
	struct Queue* q = createQueue();
	struct Node* node;
	int isMatch = 0;

	if (t->root == NULL || sub->root == NULL) {
		return 0;
	} // end if

	enqueue(q, t->root);

	while (!isQueueEmpty(q)) {
		node = dequeue(q);
		if (node->data == sub->root->data) {
			isMatch = treeMatch(node, sub->root);
			if (isMatch) {
				break;
				while (!isQueueEmpty(q)) {
					dequeue(q);
				} // end while
			} // end if
		} // end if

		if (node->left != NULL) {
			enqueue(q, node->left);
		} // end if
		if (node->right != NULL) {
			enqueue(q, node->right);
		} // end if
	} // end while
	
	return isMatch;
} // end isSubTree()

void destroy(struct Tree* t)
{
	destroyNode(t->root);
	t->root = NULL;
} // end destroy()
void destroyNode(struct Node* node)
{
	if (node != NULL) {
		destroyNode(node->left);
		destroyNode(node->right);
		free(node);
	} // end if
} // end destroyNode()

struct qNode* createqNode()
{
	struct qNode* node = (struct qNode*)malloc(sizeof(struct qNode));
	node->next = NULL;
	return node;
} // end createqNode()

struct Queue* createQueue()
{
	struct Queue* queue = (struct Queue*)malloc(sizeof(struct Queue));
	queue->front = queue->rear = NULL;
	return queue;
} // end createQueue()

void enqueue(struct Queue* q, struct Node* data)
{
	struct qNode* node = createqNode();
	node->data = data;

	if (q->rear != NULL) {
		q->rear->next = node;
		q->rear = node;
	} // end if
	else {
		q->front = q->rear = node;
	} // end else
} // end enqueue()

struct Node* dequeue(struct Queue* q)
{
	struct Node* data;
	struct qNode* temp;

	temp = q->front;
	q->front = temp->next;
	if (q->front == NULL) {
		q->rear = NULL;
	} // end if

	data = temp->data;
	free(temp);
	return data;
} // end dequeue()


int isQueueEmpty(struct Queue* q)
{
	return q->front == NULL;
} // end isQueueEmpty()


