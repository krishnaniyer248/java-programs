package datastructures_basics.doublylinkedlists;

public class DoublyLinkedList {

    private Node first;
    private Node last;

    public DoublyLinkedList(){
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return (first == null & last == null);
    }

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()){
            last = newNode;
        }
        else{
            newNode.next = first;
            first.previous = newNode;
        }
        first = newNode;
    }

    public void insertLast(int data){
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()){
            first = newNode;
        }
        else{
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
    }

    public Node deleteFirst(){
        if (isEmpty()){
            System.out.println("List is empty. Delete first - failed");
            return null;
        }
        Node temp = first;
        if (first.next == null || last.previous == null){
            first = null;
            last = null;
        }
        else {
            first = first.next;
            first.previous = null;
        }
        System.out.print("Deleted first node: ");
        temp.displayNode();
        System.out.println();
        return temp;
    }

    public Node deleteLast(){
        if (isEmpty()){
            System.out.println("List is empty. Delete last - failed");
            return null;
        }
        Node temp = last;
        if (first.next == null || last.previous == null){
            first = null;
            last = null;
        }
        else{
            last = last.previous;
            last.next = null;
        }
        System.out.print("Deleted last node: ");
        temp.displayNode();
        System.out.println();
        return temp;
    }

    public boolean insertAfter(int key, int data){
        Node newNode = new Node();
        newNode.data = data;
        Node current = first;
        while(current.data != key){
            current = current.next;
            if (current == null){
                System.out.println("Key not found. Data not inserted");
                return false;
            }
        }
        if (current.next == null){
            insertLast(data);
        }
        else {
            current.next.previous = newNode;
            newNode.next = current.next;
            current.next = newNode;
            newNode.previous = current;
        }
        System.out.println("Key found. Data inserted");
        return true;
    }

    public boolean deleteKey(int key){
        if (isEmpty()){
            System.out.println("The list is empty. Delete key failed");
            return false;
        }
        Node current = first;
        while (current.data != key){
            current = current.next;
            if (current == null){
                System.out.println("Key not found. Delete key failed");
                return false;
            }
        }
        if (current.next == null){
            deleteLast();
        }
        else if (current.previous == null){
            deleteFirst();
        }
        else{
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        System.out.print("Key deleted: ");
        current.displayNode();
        System.out.println();
        return true;
    }

    public void displayListForward(){
        System.out.print("Start->");
        Node current = first;
        while(current != null){
            current.displayNode();
            current = current.next;
            System.out.print("->");
        }
        System.out.println("End");
    }

    public void displayListReverse(){
        System.out.print("End->");
        Node current = last;
        while(current != null){
            current.displayNode();
            current = current.previous;
            System.out.print("->");
        }
        System.out.println("Start");
    }

}
