package programs.linkedlists_doubly;

import java.util.HashSet;

public class RemoveDuplicatesUnsorted {

    class Node{
        int data;
        Node next;
        Node prev;
        private Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private static Node first;
    private static Node last;

    private boolean isEmpty(){
        return (first == null);
    }

    private void insertFirst(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            first = newNode;
            last = newNode;
        }
        else{
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
    }

    private void displayList(){
        Node current = first;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    private void removeDuplicates(){
        HashSet<Integer> hash = new HashSet<>();
        Node current = first;
        Node prev = null;
        while (current != null){
            if (hash.contains(current.data)){
                prev.next = current.next;
            }
            else{
                hash.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args){

        RemoveDuplicatesUnsorted list = new RemoveDuplicatesUnsorted();
        list.insertFirst(12);
        list.insertFirst(12);
        list.insertFirst(10);
        list.insertFirst(4);
        list.insertFirst(8);
        list.insertFirst(4);
        list.insertFirst(6);
        list.insertFirst(4);
        list.insertFirst(4);
        list.insertFirst(8);
        list.insertFirst(8);
        list.displayList();
        list.removeDuplicates();
        list.displayList();
    }

}
