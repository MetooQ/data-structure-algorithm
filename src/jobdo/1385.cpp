#include <stdio.h>
#include <stdlib.h>

typedef int DataType;

struct Node {
	DataType data;
	struct Node* left;
	struct Node* right;
};

// 有头结点的二叉树，头结点的right指向树根节点
typedef struct Node BiTreeNode;

// 根据前序遍历和后续遍历构造二叉树，如不能构造，返回NULL
// pre in 为前序后续遍历的节点链表有头结点
BiTreeNode* parse(BiTreeNode* pre, BiTreeNode* in);

// 后续遍历没有根节点的二叉树
void postOrder(BiTreeNode* root);

void destroy(BiTreeNode* root);
BiTreeNode* createNode();

int main()
{
	int n;
	int index;
	BiTreeNode* pre = NULL;
	BiTreeNode* in = NULL;
	BiTreeNode* root = NULL;
	BiTreeNode* temp = NULL;
	BiTreeNode* tail = NULL;

	while (scanf("%d", &n) == 1) {
		pre = createNode();
		in = createNode();

		tail = pre;
		for (index = 0; index < n; ++index) {
			temp = createNode();
			scanf("%d", &temp->data);
			tail->right = temp;
			tail = temp;
		} // end for

		tail = in;
		for (index = 0; index < n; ++index) {
			temp = createNode();
			scanf("%d", &temp->data);
			tail->right = temp;
			tail = temp;
		} // end for

		root = parse(pre, in);
		if (root != NULL) {
			postOrder(root->right);
		} // end if
		else {
			printf("No");
		} // end else
		printf("\n");
/*
		destroy(root);
		root = NULL;
		destroy(in);
		in = NULL;
		destroy(pre);
		pre = NULL;
		*/
	} // end while

	return 0;
} // end main()

BiTreeNode* createNode()
{
	BiTreeNode* node = (BiTreeNode*)malloc(sizeof(BiTreeNode));
	node->left = NULL;
	node->right = NULL;
	return node;
} // end createNode()


void destroy(BiTreeNode* root)
{
	if (root != NULL) {
		destroy(root->left);
		destroy(root->right);
		root->left = NULL;
		root->right = NULL;
		free(root);
	} // end if
} // end destroy()


void postOrder(BiTreeNode* root)
{
	if (root == NULL) {
		return;
	} // end if
	postOrder(root->left);
	postOrder(root->right);
	printf("%d ", root->data);
} // end postOrder()

BiTreeNode* parse(BiTreeNode* pre, BiTreeNode* in)
{
	BiTreeNode* root = NULL;
	BiTreeNode* left = NULL;
	BiTreeNode* right = NULL;
	BiTreeNode* leftPre = NULL;
	BiTreeNode* leftIn = NULL;
	BiTreeNode* rightPre = NULL;
	BiTreeNode* rightIn = NULL;

	root = createNode();
	// 如果前序遍历、中序遍历都为空。返回根节点为空的树
	if (pre->right == NULL && in->right == NULL) {
		return root;
	} // end if

	root->right = pre->right;
	leftPre = pre->right;
	leftIn = in;

	// 在中序遍历中寻找根元素，用于划分左右子树
	pre = pre->right;
	while (pre->right != NULL && in->right != NULL
		&& in->right->data != root->right->data) {
			pre = pre->right;
			in = in->right;
	} // end while

	// 如果中序遍历中不能找到前序遍历首节点（根节点）返回NULL表示输入
	// 不能构造二叉树
	if (in->right->data != root->right->data) {
		free(root);
		root = NULL;
		return NULL;
	} // end if

	rightPre = createNode();
	rightIn = createNode();
	
	rightPre->right = pre->right;
	pre->right = NULL;

	rightIn->right = in->right->right;
	in->right = NULL;

	left = parse(leftPre, leftIn);
	right = parse(rightPre, rightIn);

	// 如果任何子树不能解析，返回NULL
	if (left == NULL || right == NULL) {
		free(root);
		return NULL;		
	} // end if

	root->right->right = right->right;
	root->right->left = left->right;

	free(right);
	free(left);

	return root;
} // end parse()

