package datastructures_basics.queues;

public class QueuesMain {

    public static void main(String[] args){

        Queues q = new Queues(5);

        q.insert('a');
        q.insert('b');
        q.insert('c');
        q.insert('d');
        q.displayQueue();
        q.remove();
        q.remove();
        q.displayQueue();
        q.remove();
        q.remove();
        q.displayQueue();
        q.insert('x');
        q.insert('y');
        q.insert('z');
        q.displayQueue();
        q.remove();
        q.displayQueue();
    }

}
