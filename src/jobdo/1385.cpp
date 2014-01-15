#include <stdio.h>
#include <stdlib.h>

typedef int DataType;

struct Node {
	DataType data;
	struct Node* left;
	struct Node* right;
};

// ��ͷ���Ķ�������ͷ����rightָ�������ڵ�
typedef struct Node BiTreeNode;

// ����ǰ������ͺ�������������������粻�ܹ��죬����NULL
// pre in Ϊǰ����������Ľڵ�������ͷ���
BiTreeNode* parse(BiTreeNode* pre, BiTreeNode* in);

// ��������û�и��ڵ�Ķ�����
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
	// ���ǰ����������������Ϊ�ա����ظ��ڵ�Ϊ�յ���
	if (pre->right == NULL && in->right == NULL) {
		return root;
	} // end if

	root->right = pre->right;
	leftPre = pre->right;
	leftIn = in;

	// �����������Ѱ�Ҹ�Ԫ�أ����ڻ�����������
	pre = pre->right;
	while (pre->right != NULL && in->right != NULL
		&& in->right->data != root->right->data) {
			pre = pre->right;
			in = in->right;
	} // end while

	// �����������в����ҵ�ǰ������׽ڵ㣨���ڵ㣩����NULL��ʾ����
	// ���ܹ��������
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

	// ����κ��������ܽ���������NULL
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

