#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
	int data;
	struct TreeNode* left;
	struct TreeNode* right;
};

struct Tree{
	struct TreeNode* root;
};

struct qNode{
	struct TreeNode* data;
	struct qNode* next;
};
struct Queue {
	struct qNode* front;
	struct qNode* rear;
};

struct qNode* createQNode();
struct Queue* createQueue();
void enqueue(struct Queue* q, struct TreeNode* e);
struct TreeNode* dequeue(struct Queue* q);
int isQueueEmpty(struct Queue* q);


struct TreeNode* createTreeNode();
struct Tree* createTree();
struct Tree* constructTree(int n);
void levelOrder(struct TreeNode* root);
void destroyTree(struct TreeNode* root);


int main()
{
	int n;
	struct Tree* tree = NULL;

	while (scanf("%d", &n) != EOF) {
		tree = constructTree(n);
		levelOrder(tree->root);
		printf("\n");
	} // end while

	return 0;
} // end main()

struct qNode* createQNode()
{
	struct qNode* node = (struct qNode*)malloc(sizeof (struct qNode));
	node->next = NULL;
	return node;
} // end createQNode()

struct Queue* createQueue()
{
	struct Queue* q = (struct Queue*)malloc(sizeof (struct Queue));
	q->front = q->rear = NULL;
	return q;
} // end createQueue()

void enqueue(struct Queue* q, struct TreeNode* e)
{
	struct qNode* node = createQNode();
	node->data = e;

	if (q->front != NULL) {
		q->rear->next = node;
		q->rear = node;
	} // end if
	else {
		q->front = q->rear = node;
	} // end if
} // end enqueue()

struct TreeNode* dequeue(struct Queue* q)
{
	struct qNode* temp = q->front;
	struct TreeNode* data = temp->data;

	q->front = temp->next;
	if (q->front == NULL) {
		q->rear = NULL;
	} // end if
	free(temp);

	return data;
} // end dequeue()

int isQueueEmpty(struct Queue* q)
{
	return q->front == NULL;
} // end isQueueEmpty()



struct TreeNode* createTreeNode()
{
	struct TreeNode* node = (struct TreeNode*)malloc(sizeof (struct TreeNode));
	node->left = node->right = NULL;
	return node;
} // end createTreeNode()

struct Tree* createTree()
{
	struct Tree* tree = (struct Tree*)malloc(sizeof (struct Tree));
	tree->root = NULL;
	return tree;
} // end createTree()

struct Tree* constructTree(int n)
{
	struct TreeNode* data[1001];
	int count;
	char opt[3];
	int child;
	struct Tree* tree = createTree();

	for (count = 1; count <= n; ++count) {
		data[count] = createTreeNode();
		scanf("%d", &data[count]->data);
	} // end for

	for (count = 1; count <= n; ++count) {
		scanf("%s", opt);
		switch (opt[0]) {
		case 'd':
			scanf("%d", &child);
			data[count]->left = data[child];
			scanf("%d", &child);
			data[count]->right = data[child];
			break;
			
		case 'l':
			scanf("%d", &child);
			data[count]->left = data[child];
			break;

		case 'r':
			scanf("%d", &child);
			data[count]->right = data[child];
			break;

		default:
			break;
		} // end switch
	} // end for

	tree->root = data[1];
	return tree;
} // end constructTree()


void levelOrder(struct TreeNode* root)
{
	struct Queue* q = NULL;
	struct TreeNode* node = NULL;

	if (root != NULL) {
		q = createQueue();
		
		if (root->left != NULL) {
			enqueue(q, root->left);
		} // end if
		if (root->right != NULL) {
			enqueue(q, root->right);
		} // end if
		printf("%d", root->data);

		while (!isQueueEmpty(q)) {
			node = dequeue(q);
			if (node->left != NULL) {
				enqueue(q, node->left);
			} // end if
			if (node->right != NULL) {
				enqueue(q, node->right);
			} // end if
			printf(" %d", node->data);
		} // end while

	} // end if
} // end levelOrder()


void destroyTree(struct TreeNode* root)
{
	if (root != NULL) {
		destroyTree(root->left);
		destroyTree(root->right);
		free(root);
	} // end if
} // end destroyTree()

