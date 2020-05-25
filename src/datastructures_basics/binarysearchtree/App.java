package datastructures_basics.binarysearchtree;

public class App {

    public static void main (String[] args){

        BST bst = new BST();

        bst.insert(53, "fifty three");
        bst.insert(28, "twenty eight");
        bst.insert(63, "sixty three");
        bst.insert(15, "fifteen");
        bst.insert(29, "twenty nine");
        bst.insert(57, "fifty seven");
        bst.insert(100, "hundred");
        bst.insert(97, "ninety seven");
        bst.insert(96, "ninety six");

//        bst.findMax();
//        bst.findMin();

//        bst.displayBST();
        bst.newPrintBST();

        bst.remove(63);
        bst.newPrintBST();
    }

}
