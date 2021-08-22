package datastructures_basics.heaps;

public class MaxHeap {

    private int[] heap;
    private int size;

    MaxHeap(int capacity){
        heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int value){
        if (isFull())
            throw new IndexOutOfBoundsException("Heap is full");

        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    public int  delete(int index){
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty");

        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size - 1]; // replacing the deleted value with the last value in the array

        if (index == 0 || heap[index] < heap[parent])
            fixHeapBelow(index, size-1);
        else
            fixHeapAbove(index);

        size--;

        return deletedValue;
    }

    public void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;

        while(index <= lastHeapIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex){
                if (rightChild > lastHeapIndex)
                    childToSwap = leftChild;
                else
                    childToSwap = (heap[leftChild] > heap[rightChild]) ? leftChild : rightChild;
                if (heap[index] < heap[childToSwap]){
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                }
                else
                    break;
                index = childToSwap;
            }
            else
                break;
        }

    }

    public void fixHeapAbove(int index){
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    public void sort(){
        int lastHeapIndex = size - 1;
        for (int i=0; i<lastHeapIndex; i++){
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = temp;
            fixHeapBelow(0, lastHeapIndex - i -1);
        }

    }

    public int peek(){
        if (isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty");
        return heap[0];
    }

    public boolean isFull(){
        return (size == heap.length);
    }

    public boolean isEmpty(){
        return (size ==0);
    }

    public void printHeap(){
        for (int i=0; i<size; i++){
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public int getParent(int index){
        return (index-1)/2;
    }

    public int getChild(int index, boolean isLeft){
        return 2 * index + (isLeft ? 1 : 2);
    }

}
