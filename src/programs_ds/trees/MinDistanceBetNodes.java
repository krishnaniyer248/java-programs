/*
Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two
different nodes in the tree.
Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 */

package programs_ds.trees;

public class MinDistanceBetNodes {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        private TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
        private TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode root;
    private static int min = Integer.MAX_VALUE;
    private static TreeNode prev = null;

    private void insertNode(int val){
        TreeNode newNode = new TreeNode(val);
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeft = true;
        if (root == null)
            root = newNode;
        else{
            while(current != null){
                parent = current;
                if (val <= current.val){
                    current = current.left;
                    isLeft = true;
                }
                else{
                    current = current.right;
                    isLeft = false;
                }
            }
            if (isLeft)
                parent.left = newNode;
            else
                parent.right = newNode;
        }
    }

    private void displayInOrder(TreeNode node){

        if(node == null)
            return;

        displayInOrder(node.left);
        System.out.print(node.val + " ");
        displayInOrder(node.right);
    }

    private int getMinDistance(TreeNode node){

        if (node == null)
            return min;

        getMinDistance(node.left);

        if(prev != null)
            min = Math.min(node.val - prev.val, min);
        prev = node;

        getMinDistance(node.right);

        return min;
    }

    public static void main(String[] args){

        MinDistanceBetNodes tree = new MinDistanceBetNodes();

        tree.insertNode(56);
        tree.insertNode(26);
        tree.insertNode(87);
        tree.insertNode(75);
        tree.insertNode(100);
        tree.insertNode(15);
        tree.insertNode(30);
        tree.insertNode(4);
        tree.insertNode(145);

        System.out.print("InOrder display: ");
        tree.displayInOrder(root);
        System.out.println();

        System.out.println("Min Distance: " + tree.getMinDistance(root));

    }

}
