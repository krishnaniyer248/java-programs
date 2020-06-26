package programs_ds.linkedlists_singly;

import java.util.HashMap;

public class GetNthNodeFromEnd {

    class Node{
        int data;
        Node next;
        private Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node first = null;

    private boolean isEmpty(){
        return (first == null);
    }
    private void insertFirst(int data){
        Node newNode = new Node(data);
        if (isEmpty()){
            first = newNode;
        }
        else{
            newNode.next = first;
            first = newNode;
        }
    }

    private void displayList(){
        Node current = first;
        System.out.print("Start->");
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print("End");
        System.out.println();
    }

    private int getNthNodeUsingHash(int n){
        Node current = first;
        HashMap<Integer, Node> hash = new HashMap<>();
        int count = 1;
        while(current != null){
            hash.put(count, current);
            current = current.next;
            count++;
        }
        count--;
        System.out.println("node " + n + ": ");
        return hash.get(count-n+1).data;
    }

    private int getNthNodeWithoutHash(int n){
        Node current = first;
        int count = 0;
        while(current != null){
            current = current.next;
            count++;
        }
        int reqNodeCount = count-n+1;
        int node = 1;
        Node newCurrent = first;
        while(node != reqNodeCount){
            newCurrent = newCurrent.next;
            node++;
        }
        System.out.println("node " + n + ": ");
        return newCurrent.data;
    }

    /**
     * Use 2 pointers pNthNode and pTemp. Initially, both point to the head node of the list. pNthNode starts moving
     * only after pTemp has made n moves. From there both move forward until pTemp reaches the end of the list. As a
     * result pNthNode points to the nth node from the end of the linked list.
     */
    private int getNthNodeWith2Pointers(int n){
        Node pNthNode = first;
        Node pTemp = first;
        for (int count = 1; count <= n; count++){
            if(pTemp != null)
                pTemp = pTemp.next;
        }
        while(pTemp != null){
            pNthNode = pNthNode.next;
            pTemp = pTemp.next;
        }
        if(pNthNode != null)
            return pNthNode.data;
        return -1;
    }

    public static void main(String[] args){
        GetNthNodeFromEnd list = new GetNthNodeFromEnd();
        list.insertFirst(45);
        list.insertFirst(2);
        list.insertFirst(39);
        list.insertFirst(97);
        list.insertFirst(12);
        list.displayList();
        System.out.println(list.getNthNodeUsingHash(1));
        System.out.println(list.getNthNodeWithoutHash(2));
        System.out.println(list.getNthNodeWith2Pointers(3));
    }

}
