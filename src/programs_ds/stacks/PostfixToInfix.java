package programs_ds.stacks;

/*
Examples of infix to postfix conversion
   Infix              Prefix            Postfix
A + B * C + D	    + + A * B C D	  A B C * + D +
(A + B) * (C + D)	* + A B + C D	  A B + C D + *
A * B + C * D	    + * A B * C D	  A B * C D * +
A + B + C + D	    + + + A B C D	  A B + C + D +
a+b*(c^d-e)^(f+g*h)-i               abcd^e-fgh*+^*+i-
*/

import java.util.Stack;

public class PostfixToInfix{

    public static void main(String[] args){

//        String expression = "ABC*+D+";
//        String expression = "AB+CD+*";
//        String expression = "AB*CD*+";
        String expression = "abcd^e-fgh*+^*+i-";

        String inFixExp = convertToInfix(expression);

        System.out.println("InFix Expression: " + inFixExp);

    }

    public static String convertToInfix(String exp){

        String returnExp = "";
        Stack<String> st = new Stack<>();

        for (int i=0; i<exp.length(); i++){
            char c = exp.charAt(i);
            if ((c >= 'A' && c <= 'Z')|| (c >= 'a' && c <= 'z')){
                st.push(c + "");
            }
            else{
                String op1 = st.peek();
                st.pop();
                String op2 = st.peek();
                st.pop();
                st.push("(" + op2 + exp.charAt(i) + op1 + ")");
            }
        }

        return st.peek();
    }

}
/*
Algorithm
1.While there are input symbol left
…1.1 Read the next symbol from the input.
2.If the symbol is an operand
…2.1 Push it onto the stack.
3.Otherwise,
…3.1 the symbol is an operator.
…3.2 Pop the top 2 values from the stack.
…3.3 Put the operator, with the values as arguments and form a string.
…3.4 Push the resulted string back to stack.
4.If there is only one value in the stack
…4.1 That value in the stack is the desired infix string.
 */