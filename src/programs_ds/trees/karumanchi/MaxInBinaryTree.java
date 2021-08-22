package programs_ds.trees.karumanchi;

import java.util.LinkedList;
import java.util.Queue;

public class MaxInBinaryTree {

    private static class Node{
        int data;
        Node left;
        Node right;
        private Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static Node root;

    private void insertNode(int data){
        Node newNode = new Node (data);
        boolean isLeftChild = true;
        Node parent = root;
        if (root == null){
            root = newNode;
        }
        else{
            Node current = root;
            while (current != null){
                parent = current;
                if(data <= current.data){
                    current = current.left;
                    isLeftChild = true;
                }
                else{
                    current = current.right;
                    isLeftChild = false;
                }
            }
            if(isLeftChild){
                parent.left = newNode;
            }
            else
                parent.right = newNode;
        }
    }

    public int getMaximumNumberRecursion(Node root){
        int maxValue = Integer.MIN_VALUE;
        if (root != null){
            int leftMax = getMaximumNumberRecursion(root.left);
            int rightMax = getMaximumNumberRecursion(root.right);
            if(leftMax > rightMax){
                maxValue = leftMax;
            }
            else{
                maxValue = rightMax;
            }
            if(root.data > maxValue){
                maxValue = root.data;
            }
        }
        return maxValue;
    }

    public int getMaximumNumberIterative(Node root){
        if(root == null) return Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.data > maxValue)
                maxValue = temp.data;
            if(temp != null){
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            }
        }
        return maxValue;
    }

    public static void main (String[] args){

        MaxInBinaryTree bst = new MaxInBinaryTree();
        bst.insertNode(22);
        bst.insertNode(100);
        bst.insertNode(54);
        bst.insertNode(9);
        bst.insertNode(60);
        bst.insertNode(15);
        bst.insertNode(2);
        bst.insertNode(105);

//        System.out.println(bst.getMaximumNumberRecursion(root));
        System.out.println(bst.getMaximumNumberIterative(root));

    }

}
