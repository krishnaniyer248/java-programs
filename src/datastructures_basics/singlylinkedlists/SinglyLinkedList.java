package datastructures_basics.singlylinkedlists;

public class SinglyLinkedList {

    private Node first;

    public SinglyLinkedList(){
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;
        first = newNode;
    }

    public void insertLast(int data){
        Node newNode = new Node();
        newNode.data = data;
        Node current = first;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public Node deleteFirst(){
        Node current = first;
        first = current.next;
        System.out.println("Deleted node: {" + current.data + "}");
        return current;
    }

    public void displayList(){
        System.out.print("Start->");

        Node current = first;
        while(current != null){
            current.displayNode();
            System.out.print("->");
            current = current.next;
        }
        System.out.println("End");
    }

}
