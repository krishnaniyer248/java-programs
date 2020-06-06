package programs_ds.stacks;

import java.util.Stack;

public class InfixToPrefix{

    public static void main(String[] args){

        String exp = "A+B*C"; // output -> +A*BC
        System.out.println("Prefix Expression: " + convertToPrefix(exp));

    }

    public static String convertToPrefix(String exp){

        //Reverse the expression
        String reverseExp = reverseExpression(exp);
        System.out.println("ReverseExp: " + reverseExp);

        // Convert to Postfix expression
        String postfixExpression = convertToPostfix(reverseExp);
        System.out.println("PostFix Expression: " + postfixExpression);

        // Reverse the postfix expression - this is the required prefix expression
        return reverseExpression(postfixExpression);
    }

    public static String convertToPostfix(String revExp){

        String pfExp = "";
        Stack<Character> st = new Stack<>();
        for (int i=0; i<revExp.length(); i++){
            char c = revExp.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                pfExp = pfExp + c;
            }
            else if (c == '('){
                st.push(c);
            }
            else if (c == ')'){
                while (!st.isEmpty() && st.peek() != '('){
                    pfExp = pfExp + st.pop();
                }
                st.pop();
            }
            else{
                while (!st.isEmpty() && (getPriority(c) <= getPriority(st.peek()))){
                    pfExp = pfExp + st.pop();
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()){
            pfExp = pfExp + st.pop();
        }

        return pfExp;
    }

    public static int getPriority(char c){

        switch(c){
            case '+':
            case '-':
                return 1;

            case '/':
            case '*':
                return 2;

            case '^':
                return 3;

            default:
                return -1;
        }

    }

    public static String reverseExpression(String exp){

        String revExp = "";
        for (int i=exp.length()-1; i>=0; i--){
            if (exp.charAt(i) == '(')
                revExp = revExp + ')';
            else if(exp.charAt(i) == ')')
                revExp = revExp + '(';
            else
                revExp = revExp + exp.charAt(i);
        }
        return revExp;
    }


}
/*
Step 1: Reverse the infix expression i.e A+B*C will become C*B+A. Note while reversing
each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
Step 2: Obtain the postfix expression of the modified expression i.e CB*A+.
Step 3: Reverse the postfix expression. Hence in our example prefix is +A*BC.
 */