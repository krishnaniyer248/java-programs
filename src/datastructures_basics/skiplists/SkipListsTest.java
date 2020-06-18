package datastructures_basics.skiplists;

public class SkipListsTest {

    public static void main(String[] args){

        SkipList s = new SkipList();
        s.add(1, 100);
        System.out.println(s.get(1));

    }

}
