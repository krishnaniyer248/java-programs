package programs_ds.trees;

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

    private void printPreorder(Node node){
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorder(node.leftChild);
        printPreorder(node.rightChild);
    }

    private void printPostorder(Node node){
        if(node == null)
            return;
        printPostorder(node.leftChild);
        printPostorder(node.rightChild);
        System.out.print(node.data + " ");
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


    }

}
