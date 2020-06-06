package programs_ds.stacks;

import java.util.Stack;

public class BalancedParanthesis{

    public static void main(String[] args){

//        String exp = "[()]{}{[()()]()}";
        String exp = "[(])";
        System.out.println("Output: " + isBalanced(exp));

    }

    public static boolean isBalanced(String exp){

        boolean flag = true;
        Stack<Character> st = new Stack<>();
        for (int i=0; i<exp.length(); i++){
            char c = exp.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                st.push(c);
            else {
                switch(c){
                    case ')':
                        flag = (st.pop() == '(');
                        break;
                    case '}':
                        flag = (st.pop() == '{');
                        break;
                    case ']':
                        flag = (st.pop() == '[');
                        break;
                }
            }
            if (!flag)
                return false;
        }
        return flag;
    }

}
