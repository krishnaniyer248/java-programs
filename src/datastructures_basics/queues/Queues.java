package datastructures_basics.queues;

public class Queues {

    private char[] queueArr;
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;

    public Queues(int size){
        this.maxSize = size;
        queueArr = new char[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(char element){
        if (rear < maxSize-1){
            rear++;
            queueArr[rear] = element;
            nItems++;
            System.out.println("Element " + element + " inserted in queue");
        }
        else{
            System.out.println("Queue is full. Element cannot be inserted");
        }
    }

    public char remove(){
        char retElement;
        if (front > rear){
            retElement = '0';
            System.out.println("The queue is empty. Element cannot be removed");
        }
        else{
            retElement = queueArr[front];
            front++;
            System.out.println("Element " + retElement + " removed");
            nItems--;
            if (front > rear){
                front = 0;
                rear = -1;
            }
        }
        return retElement;
    }

    public void displayQueue(){
        System.out.print("[");
        for (int i= rear; i>=front; i--){
            System.out.print(" " + queueArr[i] + " ");
        }
        System.out.println("]");
    }

}
