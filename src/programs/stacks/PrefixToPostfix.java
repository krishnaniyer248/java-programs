package programs.stacks;

import java.util.Stack;

public class PrefixToPostfix{

    public static void main(String[] args){

//        String exp = "*+AB-CD"; // output -> AB+CD-*
        String exp = "++A*BCD"; // output -> ABC*+D+

        System.out.println("PostFix Expression: " + convertToPostfix(exp));

    }

    public static String convertToPostfix(String str){

        Stack<String> st = new Stack<>();
        String returnExp = "";

        for (int i=str.length()-1; i>=0; i--){
            char c = str.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                st.push(c + "");
            }
            else{
                String op1 = st.peek();
                st.pop();
                String op2 = st.peek();
                st.pop();
                st.push(op1 + op2 + c);
            }

        }
        return st.pop();
    }

}
/*
Algorithm for Prefix to Postfix:

Read the Prefix expression in reverse order (from right to left)
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack
Create a string by concatenating the two operands and the operator after them.
string = operand1 + operand2 + operator
And push the resultant string back to Stack
Repeat the above steps until end of Prefix expression
 */