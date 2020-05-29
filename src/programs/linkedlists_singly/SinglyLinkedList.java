//package programs.linkedlists_singly;
//
//public class SinglyLinkedList {
//
//    public class Node{
//        private int data;
//        public Node next;
//        private Node(int d){
//            this.data = d;
//            this.next = null;
//        }
//    }
//
//    private Node first;
//    private Node last;
//
//    public SinglyLinkedList(){
//        this.first = null;
//        this.last = null;
//    }
//
//    public boolean isEmpty(){
//        return first == null;
//    }
//
//    public void insertFirst(int data){
//        Node newNode = new Node(data);
//        if (isEmpty()){
//            first = newNode;
//            last = newNode;
//        }
//        else{
//            newNode.next = first;
//            first = newNode;
//        }
//    }
//
//    public void displayList(){
//        Node current = first;
//        System.out.print("Start -> ");
//        while(current != null){
//            System.out.print(current.data + " -> ");
//            current = current.next;
//        }
//        System.out.println("End");
//
//    }
//
//
//
//}
