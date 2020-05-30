package programs.linkedlists_singly;

import java.sql.SQLOutput;

public class RemoveDuplicatesInSorted {

    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node first = null;
    private Node last = null;

    private boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            last = newNode;
        }
        else{
            newNode.next = first;
        }
        first = newNode;
    }

    private void displayList(){
        Node current = first;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    private void removeDuplicates(Node current){
        while (current != null){
            Node temp = current;
            while (temp != null && temp.data == current.data){
                temp = temp.next;
            }
            current.next = temp;
            current = current.next;
        }
        System.out.println("Duplicate nodes removed");
    }

    private Node removeDuplicatesRecursive(Node current){
        Node temp;
        if (current == null)
            return null;

        if (current.next != null){
            if (current.data == current.next.data){
                temp = current.next;
                current.next = current.next.next;
                removeDuplicatesRecursive(current);
            }
            else{
                removeDuplicatesRecursive(current.next);
            }
        }
        return current;
    }

    public static void main(String[] args){
        RemoveDuplicatesInSorted rd = new RemoveDuplicatesInSorted();
        rd.insertFirst(5);
        rd.insertFirst(5);
        rd.insertFirst(5);
        rd.insertFirst(13);
        rd.insertFirst(13);
        rd.insertFirst(20);
        rd.insertFirst(20);
        rd.displayList();
//        rd.removeDuplicates(rd.first);
        rd.removeDuplicatesRecursive(rd.first);
        rd.displayList();
    }

}
