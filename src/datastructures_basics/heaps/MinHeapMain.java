package datastructures_basics.heaps;

public class MinHeapMain {

    public static void main (String[] args){

        MinHeap minh = new MinHeap(10);

        minh.insert(25);
        minh.insert(42);
        minh.insert(12);
        minh.insert(56);
        minh.insert(5);
        minh.displayHeap();

        minh.delete(2);
        minh.insert(35);
        minh.insert(50);
        minh.displayHeap();

        minh.sort();
        System.out.print("Sorted Heap: ");
        minh.displayHeap();


    }

}
