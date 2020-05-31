package programs.linkedlists_doubly;

public class DoublyLinkedList {

    class Node{
        int data;
        Node next;
        Node prev;
        private Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private static Node first;
    private static Node last;

    private boolean isEmpty(){
        return (first == null && last == null);
    }

    private void insertFirst(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            first = newNode;
            last = newNode;
        }
        else{
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
    }

    private void insertLast(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            last = newNode;
            first = newNode;
        }
        else{
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }

    private void insertAfter(int key, int data){
        Node newNode = new Node(data);
        Node current = first;
        while(current != null){
            if (current.data == key)
                break;
            else
                current = current.next;
        }
        if (current == null)
            System.out.println("Node not found");
        else if(current == last)
            insertLast(data);
        else{
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;
        }
    }

    private boolean deleteKey(int key){
        if(isEmpty()){
            System.out.println("List is empty. Delete failed");
            return false;
        }
        Node current = first;
        while (current.data != key){
            current = current.next;
        }
        if (current == null){
            System.out.println("Node not found. Delete failed");
            return false;
        }
        else if (current == first){
            if (first.next == null){
                first = null;
                last = null;
            }
            else{
                first.next.prev = null;
                first = first.next;
            }
        }
        else if (current == last){
            if (last.prev == null){
                first = null;
                last = null;
            }
            else{
                last.prev.next = null;
                last = last.prev;
            }
        }
        else{
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return true;
    }

    private void displayList(){
        Node current = first;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    private void displayListReverse(){
        Node current = last;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(50);
        dll.insertFirst(5);
        dll.insertFirst(14);
        dll.insertFirst(8);
        dll.insertLast(47);
        dll.insertFirst(37);
        dll.insertFirst(26);
        dll.displayList();
//        dll.displayListReverse();
        dll.insertAfter(26, 99);
        dll.insertAfter(47, 55);
        dll.insertAfter(14, 33);
        dll.displayList();
        dll.deleteKey(26);
        dll.deleteKey(55);
        dll.deleteKey(14);
        dll.displayList();
        dll.displayListReverse();
    }

}
