package programs.trees;

public class BSTFromPreorderON2{

    Index index = new Index();

    Node constructTreeUtil(int[] pre, Index preIndex, int low, int high, int size){

        if (preIndex.index >= size || low > high)
            return null;

        Node root = new Node(pre[preIndex.index]);
        preIndex.index = preIndex.index + 1;

        if (low == high)
            return root;

        int i;
        for (i=1; i<=high; i++){
            if (pre[i] > root.data)
                break;
        }

        root.leftChild = constructTreeUtil(pre, preIndex, preIndex.index, i-1, size);
        root.rightChild = constructTreeUtil(pre, preIndex, i, high, size);

        return root;

    }

    Node constructTree(int[] pre, int size){
        return constructTreeUtil(pre, index, 0, size-1, size);
    }

    void printInOrder(Node node){
        if (node == null)
            return;

        printInOrder(node.leftChild);
        System.out.print(node.data + " ");
        printInOrder(node.rightChild);
    }

    void printPreorder(Node node){
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreorder(node.leftChild);
        printPreorder(node.rightChild);
    }

    public static void main(String[] args){

        BSTFromPreorderON2 tree = new BSTFromPreorderON2();

        int[] preorder = {10, 5, 1, 7, 40, 50};
//        int[] preorder = {56, 26, 15, 4, 30, 87, 75, 100, 145};
        int n = preorder.length;
        Node root = tree.constructTree(preorder, n);
        System.out.print("Inorder traversal: ");
        tree.printInOrder(root);
        System.out.println();
        System.out.print("Preorder traversal: ");
        tree.printPreorder(root);

    }
}

class Node{
    int data;
    Node leftChild;
    Node rightChild;
    Node(int data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class Index{
    int index = 0;
}
/*
Method 1 ( O(n^2) time complexity )
The first element of preorder traversal is always root. We first construct the root. Then we find the index of first
element which is greater than root. Let the index be ‘i’. The values between root and ‘i’ will be part of left subtree,
and the values between ‘i+1’ and ‘n-1’ will be part of right subtree. Divide given pre[] at index “i” and recur for left
 and right sub-trees.
For example in {10, 5, 1, 7, 40, 50}, 10 is the first element, so we make it root. Now we look for the first element
greater than 10, we find 40. So we know the structure of BST is as following.
 */