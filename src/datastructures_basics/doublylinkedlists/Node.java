package datastructures_basics.doublylinkedlists;

public class Node {

    public int data;
    public Node next = null;
    public Node previous = null;

    public void displayNode(){
        System.out.print("{" + data + "}");
    }

}
