package programs.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement{

    public static void main(String[] args){

        int[] inputArr = {4, 7, 3, 2, 10, 25};
//        int[] inputArr = {5, 4, 3, 2, 1, 6};
        System.out.println("Next Greater Element Array: " + Arrays.toString(nextGreaterElement2(inputArr)));
//        nextGreaterElement1(inputArr);
    }

    // method using stack; but the results are not in the same order -> hence printing the same
    public static void nextGreaterElement1(int[] arr){

        Stack<Integer> st = new Stack<>();
        int[] outputArr = new int[arr.length];
        // push the first element to stack
        st.push(arr[0]);
        int element, next;

        for (int i=1; i<arr.length; i++){

            next = arr[i];
            if (!st.isEmpty()){
                // if stack is not empty, then
                // pop an element from stack
                element = st.pop();

                // If the popped element is smaller than next, then a) print the pair b) keep popping while elements
                // are smaller and stack is not empty
                while(element < next){
                    System.out.println(element + "-->" + next);
                    if (st.isEmpty())
                        break;
                    element = st.pop();
                }
                // If element is greater than next, then push the element back
                if (element > next)
                    st.push(element);
            }
            // push next to stack so that we can find next greater for it
            st.push(next);
        }
        // After iterating over the loop, the remaining elements in stack do not have the next greater element,
        // so print -1 for them
        while(!st.isEmpty()){
            element = st.pop();
            next = -1;
            System.out.println(element + "-->" + next);

        }

    }

    //  method using stack and map to get the results in the same order as the input

    /*
    Suppose we have a decreasing sequence followed by a greater number
For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers
in the sequence
We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all
elements less than x and for all the popped ones, their next greater element is x
For example [9, 8, 7, 3, 2, 1, 6]
The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose
next greater element should be 6
     */
    public static int[] nextGreaterElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        int[] findNums = new int[nums.length];
        stack.push(nums[0]);
        for (int i=1; i<nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i])
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(nums[i], -1);
        return findNums;
    }

}
