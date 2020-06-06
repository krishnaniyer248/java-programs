package programs_ds.trees;

public class LevelTraversalBFS {

    class Node{
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
        Node current = root;
        boolean isLeft = true;
        if (root == null)
            root = newNode;
        else{
            while(current != null){
                parent = current;
                if(data <= current.data){
                    current = current.leftChild;
                    isLeft = true;
                }
                else{
                    current = current.rightChild;
                    isLeft = false;
                }
            }
            if(isLeft)
                parent.leftChild = newNode;
            else
                parent.rightChild = newNode;
        }
    }

    private void printLevelOrder(){

        int h = getHeight(root);
        int i;
        for (i=1; i<=h; i++){
            printGivenLevel(root, i);
        }
    }

    private int getHeight(Node node){
        if(node == null)
            return 0;
        else{
            int lHeight = getHeight(node.leftChild);
            int rHeight = getHeight(node.rightChild);
            if(lHeight > rHeight)
                return lHeight+1;
            else
                return rHeight+1;
        }
    }

    private void printGivenLevel(Node node, int level){
        if(node == null)
            return;
        if(level == 1)
            System.out.print(node.data + " ");
        else if(level > 1){
            printGivenLevel(node.leftChild, level-1);
            printGivenLevel(node.rightChild, level-1);
        }
    }

    public static void main(String[] args){

        LevelTraversalBFS tree = new LevelTraversalBFS();
        tree.insertNode(56);
        tree.insertNode(26);
        tree.insertNode(87);
        tree.insertNode(75);
        tree.insertNode(100);
        tree.insertNode(15);
        tree.insertNode(30);
        tree.insertNode(4);
        tree.insertNode(145);

        System.out.println("Level order traversal: ");

        tree.printLevelOrder();

    }

}
