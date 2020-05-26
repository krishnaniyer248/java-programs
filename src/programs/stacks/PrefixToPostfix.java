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
