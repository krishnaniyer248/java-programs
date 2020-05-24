package datastructures_basics.heaps;

public class Main {

    public static void main(String[] args){
        Heap hp = new Heap(10);

        hp.insert(25);
        hp.printHeap();
        hp.insert(55);
        hp.printHeap();
        hp.insert(75);
        hp.printHeap();

        hp.delete(0);
        hp.printHeap();

        hp.insert(80);
        hp.insert(75);
        hp.insert(60);
        hp.insert(68);
        hp.insert(55);
        hp.insert(40);
        hp.insert(52);
        hp.insert(67);

        hp.printHeap();

        hp.sort();
        hp.printHeap();

    }

}
