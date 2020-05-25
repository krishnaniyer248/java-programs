package programs.stacks;
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

public class InfixToPostfix{

    public static void main(String[] args){

//        String expression = "A+B*C+D";
//        String expression = "A * B + C * D";
//        String expression = "A + B + C + D";
//        String expression = "(A + B) * (C + D)";
        String expression = "a+b*(c^d-e)^(f+g*h)-i";

        String postFixExp = convertToPostfix(expression);

        System.out.println("PostFix Expression: " + postFixExp);

    }

    public static String convertToPostfix(String exp){

        String returnExp = "";
        Stack<Character> st = new Stack<>();
        for (int i=0; i<exp.length(); i++){

            char c = exp.charAt(i);
//            int asciiIndex = c;

            if ((c >= 65 && c <=90) || (c >= 97 && c <= 122)){
                returnExp = returnExp + c;
            }
            else if(c == '('){
                st.push(c);
            }
            else if (c == ')'){
                while (!st.isEmpty() && st.peek() != '('){
                    returnExp = returnExp + st.pop();
                }
                if (!st.isEmpty() && st.peek() != '(')
                    return "Invalid Expression";
                else
                    st.pop();
            }
            else if (c == '/' || c == '%' || c == '+' || c == '*' || c == '^' || c =='-'){

                while (!st.isEmpty() && getPrecedence(c) <= getPrecedence(st.peek())){
                    if (st.peek() == '(')
                        return "Invalid Expression";
                    returnExp = returnExp + st.pop();
                }
            st.push(c);
            }
        }
        while (!st.isEmpty()){
            if (st.peek() == '(')
                return "Invalid Expression";
            returnExp = returnExp + st.pop();
        }
        return returnExp;
    }

    public static int getPrecedence(char c){
        switch (c) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
            default:
                return 0;
        }
    }

}