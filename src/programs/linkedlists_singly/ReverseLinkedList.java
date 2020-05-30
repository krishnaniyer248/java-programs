package programs.linkedlists_singly;

public class ReverseLinkedList {

    private class Node{
        int data;
        Node next;
        private Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private static Node first = null;
    private static Node last = null;

    private boolean isEmpty(){
        return (first == null);
    }

    private void insertFirst(int data){
        Node newNode = new Node(data);
        if (isEmpty())
            last = newNode;
        else{
            newNode.next = first;
        }
        first = newNode;
    }

    private void displayList(){
        Node current = first;
        while (current!= null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    private void reverseList(Node head){
        Node current = head;
        Node prev = null;
        Node temp = null;
        while (current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        first = prev;
    }

    public static void main(String[] args){

        ReverseLinkedList rll = new ReverseLinkedList();
        rll.insertFirst(43);
        rll.insertFirst(41);
        rll.insertFirst(21);
        rll.insertFirst(11);
        rll.insertFirst(12);
        rll.insertFirst(10);
        rll.insertFirst(10);
        rll.displayList();
        rll.reverseList(first);
        rll.displayList();
    }

}
