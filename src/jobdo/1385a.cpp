#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	struct Node* left;
	struct Node* right;
};
typedef struct Node BiTreeNode;

// ����û����ͷ���Ķ�����
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

	// ������û�ҵ����ڵ㣬����NULL��ʾ����
	if (in[inIndex] != root->data) {
		free(root);
		return NULL;
	} // end if
	
	// ����ҵ����ڵ㣬�ֱ��ж������Ƿ�Ϊ�գ�1.���գ������ж�
	// 2.�������ӽڵ�Ϊ��

		
		// ������������һ���ڵ�Ϊ���ڵ㣬������Ϊ�գ�������Ҫ����
		if (inStart != inIndex) {
			left = parse(pre, preStart + 1, preIndex, in, inStart, inIndex - 1, end);
			if (left == NULL) {
				free(root);
				return NULL;
			}
		}

		// �������������һ���ڵ�Ϊ���ڵ㣬������Ϊ�գ�������Ҫ����
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


