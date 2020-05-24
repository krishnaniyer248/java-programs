package datastructures_basics.circularlinkedlists;

public class App {

    public static void main(String[] args){

        CircularLinkedList cll = new CircularLinkedList();

        cll.insertFirst(5);
        cll.insertFirst(45);
        cll.insertLast(27);
        cll.displayList();
        cll.deleteFirst();
        cll.deleteFirst();
        cll.deleteFirst();
        cll.deleteFirst();
        cll.insertLast(77);
        cll.insertFirst(25);
        cll.displayList();

    }

}
