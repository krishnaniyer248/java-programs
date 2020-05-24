package datastructures_basics.singlylinkedlists;

public class App {

    public static void main (String[] args){

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(55);
        sll.insertFirst(66);
        sll.insertLast(99);
        sll.insertLast(11);
        sll.insertFirst(32);
        sll.displayList();
        sll.deleteFirst();
        sll.displayList();
    }

}
