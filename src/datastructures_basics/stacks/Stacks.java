package datastructures_basics.stacks;

public class Stacks {

    private char[] stackArr;
    private int maxSize;
    private int top;

    public Stacks(int size){
        this.maxSize = size;
        stackArr = new char[maxSize];
        this.top = -1;
    }

    public void push(char element){
        if (top < maxSize-1){
            top++;
            stackArr[top] = element;
            System.out.println("Element " + element + " pushed");
        }
        else{
            System.out.println("The stack is full. The element cannot be pushed");
        }
    }

    public char pop(){
        char retElement;
        if (top == -1){
            System.out.println("The stack is empty. Pop not performed");
            retElement ='0';
        }
        else{
            retElement = stackArr[top];
            top--;
            System.out.println("Element " + retElement + " popped");
        }
        return retElement;
    }

    public void displayStack(){
        System.out.print("[");
        for (int i=top; i>=0; i--){
            System.out.print(" " + stackArr[i] + " ");
        }
        System.out.println("]");
    }

}
