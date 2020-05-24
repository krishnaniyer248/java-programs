package datastructures_basics.doublylinkedlists;

public class App {

    public static void main(String[] args){

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertLast(75);
        dll.insertFirst(5);
        dll.insertLast(32);
        dll.insertFirst(28);
        dll.displayListForward();
        dll.displayListReverse();
        dll.deleteFirst();
        dll.deleteLast();
        dll.displayListForward();
        dll.deleteFirst();
        dll.deleteLast();
        dll.displayListForward();
        dll.insertLast(55);
        dll.insertFirst(37);
        dll.displayListForward();
        dll.insertAfter(55, 12);
        dll.displayListForward();
        dll.deleteKey(37);
        dll.displayListForward();

    }

}
