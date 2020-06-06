package programs_ds.stacks;

import java.util.Stack;

public class PostfixToPrefix{

    public static void main(String[] args){

        String exp = "AB+CD-*";
        System.out.println("Prefix Expression: " + convertToPrefix(exp));

    }

    public static String convertToPrefix(String pfExp){

        Stack<String> st = new Stack<>();
        String preExp = "";

        for (int i=0; i<pfExp.length(); i++){
            char c = pfExp.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                st.push(c + "");
            }
            else{
                String op1 = st.peek();
                st.pop();
                String op2 = st.peek();
                st.pop();
                st.push(c + op2 + op1);
            }
        }
        return st.pop();
    }

}
/*
Algorithm for Postfix to Prefix:
Read the Postfix expression from left to right
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack
Create a string by concatenating the two operands and the operator before them.
string = operator + operand2 + operand1
And push the resultant string back to Stack
Repeat the above steps until end of Prefix expression.
 */