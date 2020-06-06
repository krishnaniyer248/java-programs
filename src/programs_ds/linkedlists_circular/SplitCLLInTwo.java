package programs_ds.linkedlists_circular;

public class SplitCLLInTwo {

    class Node{
        int data;
        Node next;
        private Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private static Node first = null;
    private static Node last = null;
    static Node head1 = null;
    static Node head2 = null;

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
            first = newNode;
            last.next = newNode;
        }
    }

    private void displayList(Node head){
        Node current = head;
        do{
            System.out.print(current.data + "->");
            current = current.next;
        }
        while(current != head);
        System.out.println();
    }

    private int getNodeCount(Node head){
        int count = 0;
        Node current = head;
        do{
            count++;
            current = current.next;
        }
        while(current != first);
        return count;
    }

    private void splitList(Node head, int count){
        int half_val = ((count%2==0) ? count/2 : (count/2)+1);
        Node current = head;
        head1 = head;
        for (int i=1; i<half_val; i++){
            current = current.next;
        }
        head2 = current.next;
        current.next = head1;
        current = head2;
        for (int i = half_val+1; i<count; i++){
            current = current.next;
        }
        current.next = head2;
    }

    public static void main(String[] args){

        SplitCLLInTwo list = new SplitCLLInTwo();
        list.insertFirst(3);
        list.insertFirst(36);
        list.insertFirst(74);
        list.insertFirst(18);
        list.insertFirst(95);
        list.insertFirst(15);
        list.insertFirst(87);
        list.insertFirst(47);
        list.insertFirst(50);
        list.insertFirst(2);
        list.displayList(first);
        list.splitList(first, list.getNodeCount(first));
        list.displayList(head1);
        list.displayList(head2);

    }

}
