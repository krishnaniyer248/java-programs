/*
There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle
and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the
next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the
executed people are removed), until only the last person remains, who is given freedom. Given the total number of
persons n and a number m which indicates that m-1 persons are skipped and m-th person is killed in circle. The task is
to choose the place in the initial circle so that you are the last one remaining and so survive.
 */

package programs.linkedlists_circular;

public class JosephusCircle {

    class Node{
        int data;
        Node next;
        private Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private static Node first;

    private void displayList(){
        Node current = first;
        do{
            System.out.print(current.data + "->");
            current = current.next;
        }
        while(current != first);
        System.out.println();
    }

    private int getJosephusPosition(int n, int m){
        first = new Node(1);
        Node prev = first;
        for (int i=2; i<=n; i++){
            Node current = new Node(i);
            prev.next = current;
            prev = current;
        }
        prev.next = first;
        System.out.print("Original List: ");
        displayList();

        Node current = first;
        prev = first;
        while (current.next != current){
            int i=1;
            while (i<m){
                prev = current;
                current = current.next;
                i++;
            }
            prev.next = current.next;
        }
        return current.data;
    }

    public static void main(String[] args){

        JosephusCircle list = new JosephusCircle();
        System.out.println("Josephus Position: " + list.getJosephusPosition(14, 2));

    }

}
