package mixed_programs.recursion;

public class StringLength {

    private int getStringLength(String str){

        if (str.isEmpty())
            return 0;

//        int i = getStringLength(str.substring(1));
//        i++;
//        return i;
        return getStringLength(str.substring(1)) + 1;

    }

    public static void main(String[] args){

        StringLength len = new StringLength();
        String inputStr = "abcdefghijk";
        int length = len.getStringLength(inputStr);
        System.out.println("The length of the string is: " + length);
    }

}
