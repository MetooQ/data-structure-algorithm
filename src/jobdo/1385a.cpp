#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	struct Node* left;
	struct Node* right;
};
typedef struct Node BiTreeNode;

// 返回没有有头结点的二叉树
BiTreeNode* parse(int pre[], int preStart, int preEnd,
	int in[], int inStart, int inEnd, int end);
BiTreeNode* createNode();
void destroy(BiTreeNode* root);
void postOrder(BiTreeNode* tree);

int main()
{
	int pre[1000];
	int in[1000];
	int size;
	int index;
	BiTreeNode* root;



	while (scanf("%d", &size) == 1) {
		for (index = 0; index < size; ++index) {
			scanf("%d", &pre[index]);
		} // end for
		for (index = 0; index < size; ++index) {
			scanf("%d", &in[index]);
		} // end for

		root = parse(pre, 0, size - 1, in, 0, size - 1, size -1);
		if (root != NULL) {
			postOrder(root);
		} // end if
		else {
			printf("No");
		} // end if
		printf("\n");
	} // end while

	return 0;
} // end main()

void postOrder(BiTreeNode* tree)
{
	if (tree != NULL) {
		postOrder(tree->left);
		postOrder(tree->right);
		printf("%d ", tree->data);
	} // end if
} // end poseOrder()


BiTreeNode* parse(int pre[], int preStart, int preEnd,
	int in[], int inStart, int inEnd, int end)
{
	BiTreeNode* root = createNode();
	BiTreeNode* left = NULL;
	BiTreeNode* right = NULL;
	int preIndex = preStart;
	int inIndex = inStart;

	root->data = pre[preStart];

	while (preIndex <= preEnd && inIndex <= inEnd && 
		in[inIndex] != root->data) {
		++preIndex;
		++inIndex;
	} // end while

	// 区间内没找到根节点，返回NULL表示出错
	if (in[inIndex] != root->data) {
		free(root);
		return NULL;
	} // end if
	
	// 如果找到根节点，分别判断左右是否为空：1.不空，解析判断
	// 2.空设置子节点为空

		
		// 如果中序遍历第一个节点为根节点，左子树为空，否则需要解析
		if (inStart != inIndex) {
			left = parse(pre, preStart + 1, preIndex, in, inStart, inIndex - 1, end);
			if (left == NULL) {
				free(root);
				return NULL;
			}
		}

		// 如果中序遍历最后一个节点为根节点，右子树为空，否则需要解析
		if (inIndex != inEnd) {
			right = parse(pre, preIndex + 1, preEnd, in, inIndex + 1, inEnd, end);
			if (right == NULL) {
				free(root);
				return NULL;
			} // end if
		} // end if

		root->left = left;
		root->right = right;

	return root;
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

BiTreeNode* createNode()
{
	BiTreeNode* node = (BiTreeNode*)malloc(sizeof(BiTreeNode));
	node->left = node->right = NULL;
	return node;
} // end createNode()


