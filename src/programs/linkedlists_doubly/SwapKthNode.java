package programs.linkedlists_doubly;

public class SwapKthNode {

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

    private int getNodeCount(){
        Node current = first;
        int count = 0;
        while (current != null){
            current = current.next;
            count++;
        }
        return count;
    }

    private boolean swapKth(int index){
        Node node1 = null;
        Node node2 = null;
        if (index > getNodeCount()){
            System.out.println("The index doesn't exist");
            return false;
        }
        else{
            Node current = first;
            int k = 1;
            while (k != index){
                current = current.next;
                k++;
            }
            node1 = current;
            current = last;
            k = 1;
            while(k != index){
                current = current.prev;
                k++;
            }
            node2 = current;
        }
        if (node1 == node2){
            System.out.println("The nodes are the same");
        }
        else{
            int temp = node1.data;
            node1.data = node2.data;
            node2.data = temp;
        }
        return true;
    }

    public static void main(String[] args){
        SwapKthNode list = new SwapKthNode();
        list.insertFirst(14);
        list.insertFirst(78);
        list.insertFirst(39);
        list.insertFirst(63);
        list.insertFirst(44);
        list.displayList();
        System.out.println("Node count: " + list.getNodeCount());
        list.swapKth(2);
        list.displayList();
    }

}
