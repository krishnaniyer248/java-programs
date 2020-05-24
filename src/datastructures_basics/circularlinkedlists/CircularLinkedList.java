package datastructures_basics.circularlinkedlists;

public class CircularLinkedList {

    private Node first;
    private Node last;

    public CircularLinkedList(){
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return (first == null && last == null);
    }

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty())
            last = newNode;
        newNode.next = first;
        first = newNode;
        System.out.print("Insert First:");
        newNode.displayNode();
        System.out.println();
    }

    public void insertLast(int data){
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()){
            first = newNode;
        }
        else{
            last.next = newNode;
        }
        last = newNode;
        System.out.print("Insert Last:");
        newNode.displayNode();
        System.out.println();
    }

    public Node deleteFirst(){
        if (isEmpty()){
            System.out.println("List is empty. Delete failed");
            return null;
        }
        Node temp = first;
        if (first.next == null){
            first = null;
            last = null;
        }
        else{
            first = first.next;
        }
        System.out.print("Deleted Node: ");
        temp.displayNode();
        System.out.println();
        return temp;
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
