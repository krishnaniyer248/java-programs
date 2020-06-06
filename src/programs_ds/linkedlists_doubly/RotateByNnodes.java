package programs_ds.linkedlists_doubly;

public class RotateByNnodes {

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
        if(isEmpty()){
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

    private int getNodeCount(){
        Node current = first;
        int count = 0;
        while(current != null){
            current = current.next;
            count++;
        }
        return count;
    }

    private boolean rotateList(int pos){
        Node current = first;
        int i = 1;
        int loops = pos % getNodeCount();
        if (loops==0){
            System.out.println("No change in position of nodes");
            return false;
        }
        while(i<=loops){
            current = current.next;
            i++;
        }
        first.prev = last;
        last.next = first;
        first = current;
        last = current.prev;
        last.next = null;
        current.prev = null;
        return true;
    }

    public static void main(String[] args){

        RotateByNnodes list = new RotateByNnodes();
        list.insertFirst(3);
        list.insertFirst(21);
        list.insertFirst(79);
        list.insertFirst(26);
        list.insertFirst(5);
        list.insertFirst(10);
        list.insertFirst(44);
        list.displayList();
        list.rotateList(2);
        list.displayList();

    }


}
