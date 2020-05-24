package datastructures_basics.stacks;

public class StacksMain {

    public static void main (String[] args){

        Stacks st = new Stacks(5);

        st.pop();
        st.push('a');
        st.push('b');
        st.push('c');
        st.push('d');
        st.push('e');
        st.displayStack();
        st.pop();
        st.pop();
        st.pop();
        st.displayStack();

    }

}
