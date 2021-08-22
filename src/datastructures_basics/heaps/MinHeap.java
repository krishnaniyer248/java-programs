package datastructures_basics.heaps;

public class MinHeap {

    private int[] heap;
    private int size;

    MinHeap(int capacity){
        heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int value){
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException("The heap is full");
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    public int delete(int index){
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException("The heap is empty");
        }
        int deletedValue = heap[index];
        int parent = getParent(index);

        heap[index] = heap[size-1];

        if(index == 0 || heap[index] > heap[parent]){
            fixHeapBelow(index, size-1);
        }
        else{
            fixHeapAbove(size);
        }
        size--;
        return deletedValue;
    }

    public void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;
        while(index <= lastHeapIndex){
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if(leftChild <= lastHeapIndex){
                if(rightChild > lastHeapIndex){
                    childToSwap = leftChild;
                }
                else
                    childToSwap = (heap[leftChild] < heap[rightChild]) ? leftChild : rightChild;
                if(heap[index] > heap[childToSwap]){
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
        while (index > 0 && newValue < heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    public void displayHeap(){
        for (int i=0; i<size; i++){
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    public void sort(){
        int lastHeapIndex = size - 1;
        for(int i=0; i<lastHeapIndex; i++){
            int temp = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = heap[0];
            heap[0] = temp;
            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

    public int getParent(int index){
        return (index - 1) / 2;
    }

    public int getChild(int index, boolean isLeft){
        return(2 * index + (isLeft ? 1 : 2));
    }

    public boolean isFull(){
        return (size == heap.length);
    }

    public boolean isEmpty(){
        return (size == 0);
    }
}
