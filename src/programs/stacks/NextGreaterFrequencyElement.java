package programs.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterFrequencyElement{

    public static void main(String[] args){

        int[] input = {1, 1, 2, 3, 4, 2, 1}; // output: [-1, -1, 1, 2, 2, 1, -1]
//        int[] input = {1, 1, 1, 2, 2, 2, 2, 11, 3, 3}; // output: [2, 2, 2, -1, -1, -1, -1, 3, -1, -1]

        System.out.println("Output: " + Arrays.toString(nextGreaterFrequencyElement(input)));

    }

    public static int[] nextGreaterFrequencyElement(int[] inStr){

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int[] outStr = new int[inStr.length];
        int value = 0;

        for (int i=0; i<inStr.length; i++){
            if (map.containsKey(inStr[i])){
                value = map.get(inStr[i]);
                map.put(inStr[i], ++value);
            }
			else
                map.put(inStr[i], 1);
        }
        int max = Integer.MIN_VALUE;
        for (int i=0; i<inStr.length; i++){
            if (inStr[i] > max)
                max = inStr[i];
        }
        int[] freq = new int[max + 1];
        for (int i=0; i<freq.length; i++)
            freq[i] = 0;

        for (Integer k : map.keySet()){
            freq[k] = map.get(k);
        }
        for (int i=0; i<outStr.length; i++)
            outStr[i] = 0;

        map.clear();
        st.push(0);
        for (int i=1; i<inStr.length; i++){
            // If the frequency of the element which is pointed by the top of stack is less
            // than frequency of the current element, then pop the stack and continuing popping until
            // the above condition is true while the stack is not empty
            while (!st.isEmpty() && freq[inStr[st.peek()]] < freq[inStr[i]]){
                outStr[st.peek()] = inStr[i];
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            outStr[st.peek()] = -1;
            st.pop();
        }

        return outStr;
    }

}
/*
1) Create a list to use values as index to store frequency of each element.
2) Push the position of first element to stack.
3) Pick rest of the position of elements one by one and follow following steps in loop.
…….a) Mark the position of current element as ‘i’ .
……. b) If the frequency of the element which is pointed by the top of stack is greater than frequency of the current
element, push the current position i to the stack
……. c) If the frequency of the element which is pointed by the top of stack is less than frequency of the current
element and the stack is not empty then follow these steps:
…….i) continue popping the stack
…….ii) if the condition in step c fails then push the current position i to the stack
4) After the loop in step 3 is over, pop all the elements from stack and print -1 as next greater frequency element
for them does not exist.
 */