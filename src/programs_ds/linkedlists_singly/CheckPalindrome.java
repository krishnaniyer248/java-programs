package programs_ds.linkedlists_singly;

import java.util.Stack;

public class CheckPalindrome {

    static class Node{
        private int data;
        private Node next;
        public Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    public Node first = null;
    public Node last = null;

    private void insertFirst(int data){
        Node newNode = new Node(data);
        if (first == null){
            last = newNode;
            first = newNode;
        }
        else{
            newNode.next = first;
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

    static boolean isPalindrome(Node head){
        boolean isPalin = true;
        Stack<Integer> st = new Stack<>();
        Node current = head;
        while (current != null){
            st.push(current.data);
            current = current.next;
        }
        current = head;
        while (current != null){
            int d = st.pop();
            if (current.data != d){
                isPalin = false;
                break;
            }
            current = current.next;
        }
        return isPalin;
    }

    public static void main(String[] args){

        CheckPalindrome cp = new CheckPalindrome();
        cp.insertFirst(1);
        cp.insertFirst(2);
        cp.insertFirst(3);
        cp.insertFirst(2);
        cp.insertFirst(1);
        cp.displayList();
        System.out.println("Is Palindrome: " + isPalindrome(cp.first));

    }

}
