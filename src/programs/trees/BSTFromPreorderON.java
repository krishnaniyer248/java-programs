package programs.trees;

public class BSTFromPreorderON {

    Inndex index = new Inndex();

    Noode constructTreeUtil(int pre[], Inndex preIndex, int key, int min, int max, int size){
        if(preIndex.index > size)
            return null;

        Noode root = null;

        if(key > min && key < max){
            root = new Noode(key);
            preIndex.index = preIndex.index + 1;

            if (preIndex.index < size){

                root.leftChild = constructTreeUtil(pre, preIndex, pre[preIndex.index], min, key, size);
                root.rightChild = constructTreeUtil(pre, preIndex, pre[preIndex.index], key, max, size);

            }

        }

        return root;
    }

    Noode constructTree(int[] pre, int size){
        int preIndex = 0;
        return constructTreeUtil(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
    }

    private void printInorder(Noode node){
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
        Noode root = bst.constructTree(preorder, size);
        System.out.print("Inorder traversal: ");
        bst.printInorder(root);
    }

}

class Noode{
    int data;
    Noode leftChild;
    Noode rightChild;
    Noode(int data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class Inndex{
    int index = 0;
}

/*
Method 2 ( O(n) time complexity )
The idea used here is inspired from method 3 of this post. The trick is to set a range {min .. max} for every node.
Initialize the range as {INT_MIN .. INT_MAX}. The first node will definitely be in range, so create root node. To
construct the left subtree, set the range as {INT_MIN …root->data}. If a values is in the range {INT_MIN .. root->data},
 the values is part part of left subtree. To construct the right subtree, set the range as {root->data..max .. INT_MAX}.
 */