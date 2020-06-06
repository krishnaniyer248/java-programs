package programs_ds.trees;

public class BSTFromPreorderON {

    private class Node{
        int data;
        Node leftChild;
        Node rightChild;
        Node(int data){
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    private class Index{
        int index = 0;
    }

    Index index = new Index();

    Node constructTreeUtil(int pre[], Index preIndex, int key, int min, int max, int size){
        if(preIndex.index > size)
            return null;

        Node root = null;

        if(key > min && key < max){
            root = new Node(key);
            preIndex.index = preIndex.index + 1;

            if (preIndex.index < size){

                root.leftChild = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
                root.rightChild = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);

            }

        }

        return root;
    }

    Node constructTree(int[] pre, int size){
        int preIndex = 0;
        return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    private void printInorder(Node node){
        if (node == null)
            return;
        printInorder(node.leftChild);
        System.out.print(node.data + " ");
        printInorder(node.rightChild);
    }

    public static void main(String[] args){
        BSTFromPreorderON bst = new BSTFromPreorderON();
        int[] preorder = {10, 5, 1, 7, 40, 50};
        int size = preorder.length;
        Node root = bst.constructTree(preorder, size);
        System.out.print("Inorder traversal: ");
        bst.printInorder(root);
    }

}


/*
Method 2 ( O(n) time complexity )
The idea used here is inspired from method 3 of this post. The trick is to set a range {min .. max} for every node.
Initialize the range as {INT_MIN .. INT_MAX}. The first node will definitely be in range, so create root node. To
construct the left subtree, set the range as {INT_MIN …root->data}. If a values is in the range {INT_MIN .. root->data},
 the values is part part of left subtree. To construct the right subtree, set the range as {root->data..max .. INT_MAX}.
 */