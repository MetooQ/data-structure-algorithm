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

struct Node* createNode();
struct Tree* createTree();
struct Tree* constructTree(int n);
struct Node* reverse(struct Node* node);
void preOrder(struct Node* node, int isRoot);
void destroy(struct Node* node);

int main()
{

	int n;
	struct Tree* tree;

	while (scanf("%d", &n) != EOF) {
		if (n != 0) {
		tree = constructTree(n);
		tree->root = reverse(tree->root);
		preOrder(tree->root, 1);
		destroy(tree->root);
		free(tree);
		} // end if 
		else {
			printf("NULL");
		} // end else
		printf("\n");
	} // end while

	return 0;
} // end main()

struct Node* createNode()
{
	struct Node* node = (struct Node*)malloc(sizeof (struct Node));
	node->left = node->right = NULL;
	return node;
} // end createNode()


struct Tree* createTree()
{
	struct Tree* tree = (struct Tree*)malloc(sizeof (struct Tree));
	tree->root = NULL;
	return tree;
} // end createTree()


struct Tree* constructTree(int n)
{
	struct Tree* tree = createTree();
	struct Node* nodes[1000];
	struct Node* node;
	char son[4];
	int sonIndex;
	int i;

	for (i = 1; i <= n; ++i) {
		node = createNode();
		scanf("%d", &node->data);
		nodes[i] = node;
	} // end for
	for (i = 1; i <= n; ++i) {
		scanf("%s", son);
		if (son[0] == 'z') {} // end if
		else {
			scanf("%d", &sonIndex);
			if (son[0] == 'l') {
				nodes[i]->left = nodes[sonIndex];
			} // end if
			else if (son[0] == 'r') {
				nodes[i]->right = nodes[sonIndex];
			} // end else if
			else if (son[0] == 'd'){
				nodes[i]->left = nodes[sonIndex];
				scanf("%d", &sonIndex);
				nodes[i]->right = nodes[sonIndex];
			} // end else
		} // end else
	} // end for

	tree->root = nodes[1];
	return tree;
} // end constructTree()


struct Node* reverse(struct Node* node)
{
	struct Node* temp;
	if (node != NULL) {
		reverse(node->left);
		reverse(node->right);
		temp = node->left;
		node->left = node->right;
		node->right = temp;
	} // end if
	return node;
} // end reverse()


void preOrder(struct Node* node, int isRoot)
{
	if (node != NULL) {
		if (!isRoot) {
			printf(" ");
		} // end if
		printf("%d", node->data);
		preOrder(node->left, 0);
		preOrder(node->right, 0);
	} // end if
} // end preOrder()

void destroy(struct Node* node)
{
	if (node != NULL) {
		destroy(node->left);
		destroy(node->right);
		free(node);
	} // end if
} // end destroy()


