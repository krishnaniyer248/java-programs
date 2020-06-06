package programs_ds.trees;

import java.util.Stack;

public class BinarySearchTree {

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
        boolean isLeftChild = true;
        Node parent = root;
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

    private void deleteNode(int key){
        Node current = root;
        Node nodeToDelete = null;
        Node parent = root;
        boolean isLeft = true;
        while(current != null && current.data != key){
            parent = current;
            if (key < current.data){
                current = current.leftChild;
                isLeft = true;
            }
            else{
                current = current.rightChild;
                isLeft = false;
            }
        }
        if(current == null){
            System.out.println("Node not found. Delete failed");
            return;
        }

        nodeToDelete = current;
        System.out.println("Node to delete found: " + nodeToDelete.data);

        if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null){
            if (nodeToDelete == root)
                root = null;
            else if(isLeft)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }
        else if(nodeToDelete.leftChild == null || nodeToDelete.rightChild == null){
            if (nodeToDelete.leftChild != null){
                if (nodeToDelete == root)
                    root = nodeToDelete.leftChild;
                else if(isLeft)
                    parent.leftChild = nodeToDelete.leftChild;
                else
                    parent.rightChild = nodeToDelete.leftChild;
            }
            else if(nodeToDelete.rightChild != null){
                if (nodeToDelete == root)
                    root = nodeToDelete.rightChild;
                else if(isLeft)
                    parent.leftChild = nodeToDelete.rightChild;
                else
                    parent.rightChild = nodeToDelete.rightChild;
            }
        }
        else if (nodeToDelete.leftChild != null && nodeToDelete.rightChild != null){
            Node successor = getSuccessorNode(nodeToDelete);
            if (nodeToDelete == root)
                root = successor;
            else if (isLeft)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            successor.leftChild = nodeToDelete.leftChild;
        }
    }

    private Node getSuccessorNode(Node curr){
        Node nodeToDelete = curr;
        Node parent = curr;
        curr = curr.rightChild;
        while (curr.leftChild != null){
            parent = curr;
            curr = curr.leftChild;
        }
        Node successor = curr;
        if (successor != nodeToDelete.rightChild){
            parent.leftChild = successor.rightChild;
            successor.rightChild = nodeToDelete.rightChild;
        }
        return successor;
    }

    private void displayTree(){
        System.out.println("------------------------------------------ Binary Tree --------------------------------------");
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node current = root;
        stack1.push(root);
        int row = 1;
        int totalRows = 4;
        for (int i = 1; i<=Math.pow(2,totalRows); i++)
            System.out.print(" ");
        System.out.println(root.data);

        while(row <= totalRows){
            boolean isNull = true;
            for(int i=1; i<=Math.pow(2,(totalRows-row)); i++)
                System.out.print(" ");

            while(!stack1.isEmpty()){

                current = stack1.pop();
                if (current != null && current.leftChild != null){
                    stack2.push(current.leftChild);
                    System.out.print(" " + current.leftChild.data + " ");
                }
                else{
                    stack2.push(null);
                    System.out.print(" - ");
                }

                for(int i=1; i<=Math.pow(2,(totalRows-row)); i++)
                    System.out.print(" ");

                if(current != null && current.rightChild != null){
                    stack2.push(current.rightChild);
                    System.out.print(" " + current.rightChild.data + " ");
                }
                else{
                    stack2.push(null);
                    System.out.print(" - ");
                }
            }

            System.out.println();
            while(!stack2.isEmpty()){
                if (stack2.peek() != null)
                    isNull = false;
                stack1.push(stack2.pop());
            }

            if(isNull)
                break;
            row++;
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args){

        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(56);
        bst.insertNode(26);
        bst.insertNode(87);
        bst.insertNode(75);
        bst.insertNode(100);
        bst.insertNode(15);
        bst.insertNode(30);
        bst.insertNode(4);
        bst.insertNode(145);
        bst.displayTree();
        bst.deleteNode(56);
        bst.displayTree();
    }

}
