package datastructures_basics.trie;

import java.util.List;

public class App {

    public static void main (String[] args){

        Trie trie = new Trie();

        trie.insert("adam",2);
        trie.insert("adamm",20);
        trie.insert("addaz", 5);
        trie.insert("adda", 6);
        trie.insert("addaaaaz", 7);
        trie.insert("adak", 8);

        System.out.println("Value: " + trie.searchAsMap("addaz"));

        List<String> list1 = trie.allWordsWithPrefix("ada");
        System.out.println("All words with Prefix ada:");
        for (String s: list1)
            System.out.println(s);

        // To sort the elements, we can call the same method with an empty string
        System.out.println("Sorted trie");
        List<String> list2 = trie.allWordsWithPrefix("");
        for (String s: list2)
            System.out.println(s);

        System.out.println("Longest Common Prefix: " + trie.longestCommonPrefix());
    }

}
