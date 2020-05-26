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

/*
Algorithm
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.
3. Else,
…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the
stack(or the stack is empty or the stack contains a ‘(‘ ), push it.
…..3.2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than
that of the scanned operator. After doing that Push the scanned operator to the stack.
(If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.)
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop the stack and and output it until a ‘(‘ is encountered,
and discard both the parenthesis.
6. Repeat steps 2-6 until infix expression is scanned.
7. Print the output
8. Pop and output from the stack until it is not empty.
 */