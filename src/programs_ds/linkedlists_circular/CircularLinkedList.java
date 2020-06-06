package programs_ds.linkedlists_circular;

public class CircularLinkedList {

    private class Node{
        int data;
        Node next;
        boolean visited;
        private Node(int data){
            this.data = data;
            this.next = null;
            this.visited = false;
        }
    }
    private static Node first = null;
    private static Node last = null;

    private boolean isEmpty(){
        return (first == null);
    }

    private void insertFirst(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            first = newNode;
            last = newNode;
        }
        else{
            newNode.next = first;
            first = newNode;
            last.next = first;
        }
    }

    private void insertLast(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            first = newNode;
            last = newNode;
        }
        else{
            last.next = newNode;
            last = newNode;
            newNode.next = first;
        }
    }

    private void displayList(){
        Node current = first;
        do {
            System.out.print(current.data + "->");
//            current.visited = true;
            current = current.next;
        }
        while (current != first);
        System.out.println();
    }

    private void deleteKey(int data){
        Node current = first;
        Node prev = last;
        Node nodeToDelete = null;
        if (first.next == null){
            nodeToDelete = first;
            first = null;
            last = null;
        }
        else{
            do {
                if (current.data == data){
                    System.out.println("Found node: " + data);
                    nodeToDelete = current;
                    break;
                }
                prev = current;
                current = current.next;
            }
            while (current != first);

//            if (current == first){
//                System.out.println("Node not found");
//                nodeToDelete = null;
//            }

        }

        if (nodeToDelete != null){
            if (nodeToDelete == first){
                first = nodeToDelete.next;
            }
            prev.next = current.next;
        }
    }

    public static void main(String[] args){
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertLast(8);
        cll.insertFirst(5);
        cll.insertFirst(10);
        cll.insertFirst(23);
        cll.insertFirst(15);
        cll.insertLast(45);
        cll.insertLast(67);
        cll.displayList();
        cll.deleteKey(45);
        cll.displayList();
    }

}
