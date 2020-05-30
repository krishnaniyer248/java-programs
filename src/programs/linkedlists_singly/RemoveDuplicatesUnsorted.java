package programs.linkedlists_singly;

import java.util.HashSet;

public class RemoveDuplicatesUnsorted {

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

    private void insertFirst(int data){
        Node newNode = new Node(data);
        if (isEmpty())
            last = newNode;
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

    private void removeDupUnsorted(Node current){
        HashSet<Integer> hash = new HashSet<>();
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
        System.out.println("Removed Duplicates");
    }

    public static void main(String[] args){
        RemoveDuplicatesUnsorted rdu = new RemoveDuplicatesUnsorted();
        rdu.insertFirst(21);
        rdu.insertFirst(21);
        rdu.insertFirst(43);
        rdu.insertFirst(41);
        rdu.insertFirst(21);
        rdu.insertFirst(12);
        rdu.insertFirst(11);
        rdu.insertFirst(12);
        rdu.insertFirst(10);
        rdu.insertFirst(10);
        rdu.displayList();
        rdu.removeDupUnsorted(rdu.first);
        rdu.displayList();
    }

}
/*
METHOD 2 (Use Sorting)
In general, Merge Sort is the best-suited sorting algorithm for sorting linked lists efficiently.
1) Sort the elements using Merge Sort. We will soon be writing a post about sorting a linked list. O(nLogn)
2) Remove duplicates in linear time using the algorithm for removing duplicates in sorted Linked List. O(n)

Please note that this method doesn’t preserve the original order of elements.

Time Complexity: O(nLogn)
 */