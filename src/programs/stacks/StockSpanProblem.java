/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and
we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before
the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for
corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */

package programs.stacks;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem{

    public static void main(String[] args){

        int[] price = {100, 80, 60, 70, 60, 75, 85};
//        int[] price = {10, 4, 5, 90, 120, 80};

        System.out.println("Output: " + Arrays.toString(calculateSi(price)));
        System.out.println("Output: " + Arrays.toString(calculateSiNoStack(price)));

    }

    // method using stacks
    public static int[] calculateSi(int[] price){

        Stack<Integer> st = new Stack<>();
        int[] si = new int[price.length];
        // Create a stack and push index of first element to it
        st.push(0);
        // Span value of first element is always 1
        si[0] = 1;
        for (int i=1; i<price.length; i++){

            // Pop elements from stack while stack is not empty and top of stack is smaller than price[i]
            while(!st.isEmpty() && price[st.peek()] <= price[i])
                st.pop();

            // If stack becomes empty, then price[i] is greater than all elements on left of it,
            // i.e. price[0], price[1], ..price[i-1]. Else price[i] is greater than elements after top of stack
            si[i] = (st.isEmpty()) ? (i + 1) : (i - st.peek());
            // Push this element to stack
            st.push(i);
        }
        return si;
    }

    // method without using stacks
    public static int[] calculateSiNoStack(int[] price){
        int[] si = new int[price.length];
        si[0] = 1;
        for (int i=1; i<price.length; i++){
            int counter = 1;
            while ((i-counter) >= 0 && price[i] >= price[i-counter]){
                counter += si[i-counter];
            }
            si[i] = counter;
        }
        return si;
    }
}
/*
A Linear Time Complexity Method
We see that S[i] on day i can be easily computed if we know the closest day preceding i, such that the price is greater
than on that day than the price on day i. If such a day exists, let’s call it h(i), otherwise, we define h(i) = -1.
The span is now computed as S[i] = i – h(i)
To implement this logic, we use a stack as an abstract data type to store the days i, h(i), h(h(i)) and so on.
When we go from day i-1 to i, we pop the days when the price of the stock was less than or equal to price[i] and
then push the value of day i back into the stack
 */
