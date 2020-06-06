package mixed_programs.recursion;

public class Palindrome{

    public static void main(String[] args){

        String inputStr = "2002";

//        System.out.println(inputStr.substring(1).substring(1));
//        System.out.println("Is Palindrome: " + isPalindrome(inputStr));
        System.out.println("Recursive - Is Palindrome: " + isPalindromeRecursive(inputStr));

    }

    private static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i!=j && i<j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
			else{
                i++;
                j--;
            }
        }
        return true;
    }

    private static boolean isPalindromeRecursive(String str){

        String rev = getReverseString(str);
        System.out.println("Reverse string: " + rev);
        if (str.equals(rev))
            return true;
        else
            return false;
    }

    private static String getReverseString(String str){

        if (str.isEmpty())
            return str;

        return getReverseString(str.substring(1)) + str.charAt(0);

    }

}
