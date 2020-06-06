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

public class PrefixToInfix{

    public static void main(String[] args){

//        String exp = "*+AB-CD";
        String exp = "*-A/BC-/AKL";

        System.out.println("Infix expression: " + convertToInfix(exp));

    }

    public static String convertToInfix(String newexp){

        Stack<String> st = new Stack<>();
        String retExp = "";

        for (int i=newexp.length()-1; i>=0; i--){
            char c = newexp.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                st.push(c + "");
            }
            else{
                String op1 = st.peek();
                st.pop();
                String op2 = st.peek();
                st.pop();
                st.push("(" + op1 + c + op2 + ")");
            }
        }
        return st.pop();
    }

}
/*
Algorithm for Prefix to Infix:
Read the Prefix expression in reverse order (from right to left)
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack
Create a string by concatenating the two operands and the operator between them.
string = (operand1 + operator + operand2)
And push the resultant string back to Stack
Repeat the above steps until end of Prefix expression.
 */