package programs_ds.trees;

import java.util.ArrayList;
import java.util.Stack;

public class TreeTraversalDFS {

    private class Node{
        int data;
        Node leftChild;
        Node rightChild;
        private Node(int data){
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
    private static Node root;

    private void insertNode(int data){
        Node newNode = new Node(data);
        Node parent = root;
        boolean isLeftChild = true;
        if(root == null){
            root = newNode;
        }
        else{
            Node current = root;
            while(current != null){
                parent = current;
                if(data <= current.data){
                    current = current.leftChild;
                    isLeftChild = true;
                }
                else{
                    current = current.rightChild;
                    isLeftChild = false;
                }
            }
            if(isLeftChild)
                parent.leftChild = newNode;
            else
                parent.rightChild = newNode;
        }

    }

    private void printInorder(Node node){
        if(node == null)
            return;
        printInorder(node.leftChild);
        System.out.print(node.data + " ");
        printInorder(node.rightChild);
    }

    private ArrayList<Integer> printInorderIterative(Node node){
        ArrayList<Integer> al = new ArrayList<Integer>();
        Stack<Node> st = new Stack<Node>();
        if (node == null)
            return al;
        Node currentNode = node;
        boolean flag = false;
        while(!flag){
            if(currentNode != null){
                st.push(currentNode);
                currentNode = currentNode.leftChild;
            }
            else{
                if(st.isEmpty())
                    flag = true;
                else{
                    currentNode = st.pop();
                    al.add(currentNode.data);
                    currentNode = currentNode.rightChild;
                }
            }
        }
        return al;
    }

    private void printPreorder(Node node){
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorder(node.leftChild);
        printPreorder(node.rightChild);
    }

    private ArrayList<Integer> printPreorderIterative(Node node){
        Stack<Node> st = new Stack<Node>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(node == null)
            return al;
        st.push(node);
        while(!st.isEmpty()){
            Node temp = st.pop();
            al.add(temp.data);
            if(temp.rightChild != null)
                st.push(temp.rightChild);
            if(temp.leftChild != null)
                st.push(temp.leftChild);
        }
        return al;
    }

    private void printPostorder(Node node){
        if(node == null)
            return;
        printPostorder(node.leftChild);
        printPostorder(node.rightChild);
        System.out.print(node.data + " ");
    }

    private ArrayList<Integer> printPostorderIterative(Node node){
        ArrayList<Integer> al = new ArrayList<Integer>();
        Stack<Node> st = new Stack<Node>();
        if(root == null)
            return al;
        st.push(root);
        Node prev = null;
        while(!st.isEmpty()){
            Node current = st.peek();
            if(prev == null || prev.leftChild == current || prev.rightChild == current){
                if(current.leftChild != null)
                    st.push(current.leftChild);
                else if(current.rightChild != null)
                    st.push(current.rightChild);
            }
            else if(current.leftChild == prev){
                if(current.rightChild != null)
                    st.push(current.rightChild);
            }
            else{
                al.add(current.data);
                st.pop();
            }
            prev = current;
        }
        return al;
    }

    public static void main(String[] args){

        TreeTraversalDFS tree = new TreeTraversalDFS();

        tree.insertNode(56);
        tree.insertNode(26);
        tree.insertNode(87);
        tree.insertNode(75);
        tree.insertNode(100);
        tree.insertNode(15);
        tree.insertNode(30);
        tree.insertNode(4);
        tree.insertNode(145);

        System.out.print("Inorder Traversal: ");
        tree.printInorder(root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        tree.printPreorder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.printPostorder(root);
        System.out.println();

        ArrayList a = tree.printPreorderIterative(root);
        System.out.println("Preorder Iterative:" + a.toString());

        ArrayList b = tree.printInorderIterative(root);
        System.out.println("Inorder Iterative:" + b.toString());

        ArrayList c = tree.printPostorderIterative(root);
        System.out.println("Postorder Iterative:" + c.toString());

    }

}
