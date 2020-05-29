package programs.linkedlists_singly;

import java.util.HashSet;

public class DetectLoopInSLL {

    static class Node{
        private int data;
        private Node next;
        public Node(int d){
            this.data = d;
            this.next = null;
        }
    }
    static Node first = null;
    static Node last = null;

    static void insertFirst(int data){
        Node newNode = new Node(data);
        if (first == null){
            first = newNode;
            last = newNode;
        }
        else{
            newNode.next = first;
            first = newNode;
        }
    }

    static void displayList(){
        Node current = first;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }

    public static void main(String[] args){


        DetectLoopInSLL sll = new DetectLoopInSLL();
        sll.insertFirst(10);
        sll.insertFirst(5);
        sll.insertFirst(27);
        sll.insertFirst(13);
//        sll.displayList();
        sll.first.next.next.next.next = sll.first;

        System.out.println("Detect Loop: " + detectLoop(first));
        System.out.println("Detect Loop Floyd Algorithm: " + detectLoop(first));

    }

    static boolean detectLoop(Node h){
        HashSet<Node> hash = new HashSet<>();
        while (h != null){
            if (hash.contains(h))
                return true;
            hash.add(h);
            h = h.next;
        }
        return false;
    }

    static boolean detectLoopFloydAlgorithm(Node h){
        Node slow_p = h, fast_p = h;
        while(slow_p != null && fast_p != null){
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p)
                return true;
        }
        return false;
    }

}
/*
Floyd’s Cycle-Finding Algorithm: This is the fastest method and has been described below:

Traverse linked list using two pointers.
Move one pointer(slow_p) by one and another pointer(fast_p) by two. If these pointers meet at the same node then
there is a loop. If pointers do not meet then linked list doesn’t have a loop
 */
/*
Approach using Mark Visited Nodes: This solution requires modifications to the basic linked list data structure.

Have a visited flag with each node.
Traverse the linked list and keep marking visited nodes.
If you see a visited node again then there is a loop. This solution works in O(n) but requires additional information
with each node.
A variation of this solution that doesn’t require modification to basic data structure can be implemented using a hash,
just store the addresses of visited nodes in a hash and if you see an address that already exists in hash then
there is a loop
 */
/*
Marking visited nodes without modifying the linked list data structure

In this method, a temporary node is created. The next pointer of each node that is traversed is made to point to
this temporary node. This way we are using the next pointer of a node as a flag to indicate whether the node
has been traversed or not. Every node is checked to see if the next is pointing to a temporary node or not.
In the case of the first node of the loop, the second time we traverse it this condition will be true, hence we find
that loop exists. If we come across a node that points to null then loop doesn’t exist.
The code runs in O(n) time complexity and uses constant memory space.
 */