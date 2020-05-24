package datastructures_basics.binarysearchtree;

import java.util.Stack;

public class BST {

    private Node root;

    public void insert(int key, String value){
        Node newNode = new Node(key, value);

        if (root == null)
            root = newNode;
        else{
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (key < current.key){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        break;
                    }
                }
                else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        break;
                    }
                }
            }
        }

    }

    public void findMin(){
        Node current = root;
        while (current.leftChild != null){
            current = current.leftChild;
        }
        System.out.println(current.key);
    }

    public void findMax(){
        Node current = root;
        while(current.rightChild != null){
            current = current.rightChild;
        }
        System.out.println(current.key);
    }

    public boolean remove(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        while (current.key != key){
            parent = current;
            if (key < current.key){
                current = current.leftChild;
                isLeftChild = true;
            }
            else{
                current = current.rightChild;
                isLeftChild = false;
            }
            if (current == null){
                System.out.println("Key not found. Remove failed");
                return false;
            }
        }
        System.out.println("Found key: " + current.key);
//        System.out.println("Parent: " + parent.key);

        Node nodeToDelete = current;

        // if nodeToDelete is a leaf node
        if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null){
            if (nodeToDelete == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }

        // if nodeToDelete has one child on the left
        else if (nodeToDelete.rightChild == null){
            if (nodeToDelete == root)
                root = nodeToDelete.leftChild;
            else if (isLeftChild)
                parent.leftChild = nodeToDelete.leftChild;
            else
                parent.rightChild = nodeToDelete.leftChild;
        }

        // if nodeToDelete has one child on the right
        else if (nodeToDelete.leftChild == null){
            if (nodeToDelete == root)
                root = nodeToDelete.rightChild;
            else if (isLeftChild)
                parent.leftChild = nodeToDelete.rightChild;
            else
                parent.rightChild = nodeToDelete.rightChild;
        }

        // if nodeToDelete has 2 children
        else{
            Node successor = getSuccessorNode(nodeToDelete);
            if (nodeToDelete == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            successor.leftChild = nodeToDelete.leftChild;
        }
        return true;
    }

    public Node getSuccessorNode(Node nodeToDelete){
        Node successor = nodeToDelete;
        Node successorParent = nodeToDelete;
        Node current = nodeToDelete.rightChild;
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != nodeToDelete.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = nodeToDelete.rightChild;
        }
        return successor;
    }

    public void displayBST(){
        int rows=5;
        Stack<Node> st = new Stack<>();
        Stack<Node> newst = new Stack<>();
        st.push(root);
        System.out.println(root.key);
        while (rows > 0){
            while (!st.isEmpty()){
                Node newNode = st.pop();
                if (newNode != null){
                    Node leftCh = newNode.leftChild;
                    Node rightCh = newNode.rightChild;
                    if (leftCh != null){
                        System.out.print(leftCh.key + " ");
                        newst.push(leftCh);
                    }
                    if (rightCh != null){
                        System.out.print(rightCh.key + " ");
                        newst.push(rightCh);
                    }
                    if (leftCh == null){
                        System.out.print("- ");
                        newst.push(null);
                    }
                    if (rightCh == null){
                        System.out.print("- ");
                        newst.push(null);
                    }
                }
                else{
                    newst.push(null);
                    newst.push(null);
                }

            }
            System.out.println();
            while (!newst.isEmpty()){
                st.push(newst.pop());
            }
            rows--;
        }
    }

    public void newPrintBST(){
        if (root == null) {
            System.out.println("BST is empty");
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        int rows = 4;
        st1.push(root);

        for (int i=1; i<=Math.pow(2, rows); i++) {
            System.out.print(" ");
        }

        System.out.println(root.key);

        while (true) {
            rows--;
            boolean isNull = true;

            while (!st1.isEmpty()) {

                Node temp = st1.pop();

                for (int i=1; i<=Math.pow(2, rows); i++)
                    System.out.print(" ");

                if (temp != null && temp.leftChild != null) {
                    st2.push(temp.leftChild);
                    System.out.print(" " + temp.leftChild.key + " ");
                }
                else {
                    st2.push(null);
                    System.out.print(" - ");
                }

                for (int i=1; i<=Math.pow(2, rows); i++)
                    System.out.print(" ");

                if (temp != null && temp.rightChild != null) {
                    st2.push(temp.rightChild);
                    System.out.print(" " + temp.rightChild.key + " ");
                }
                else {
                    st2.push(null);
                    System.out.print(" - ");
                }
            }

            System.out.println();

            while (!st2.isEmpty()) {
                if (st2.peek() != null)
                    isNull = false;
                st1.push(st2.pop());
            }

            if (isNull)
                break;

        }
    }

}
