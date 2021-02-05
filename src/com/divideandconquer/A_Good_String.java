package com.divideandconquer;
/** Which checkes a string is a-good or not */
public class A_Good_String {
    public static void main(String[] args) {
        String input = "ccde";
        char c = 'c';
       Boolean result =  isFirstHalfGoodString(c,input) ||
        isSecondHalfGoodString(input.charAt(input.length()/2),input);

        System.out.println("Is input  string  "+input +" is "+c+"- good string? "+ result);
    }

    public static boolean isAgoodString(char c, String input) {
        if(input.length() == 1){
            return c == input.charAt(0);
        }
        int start = 0;
        int totalChars = input.length();
       return isCString(c, input.substring(start, totalChars/2)) &&
               isAgoodString((char)((int)c+1), input.substring(totalChars/2, totalChars));
    }

    public static boolean isFirstHalfGoodString(char c, String input) {
        if(input.length() == 1){
            return c == input.charAt(0);
        }
        int start = 0;
        int totalChars = input.length();
        return isCString(c, input.substring(start, totalChars/2)) &&
                isAgoodString((char)((int)c+1), input.substring(totalChars/2, totalChars));
    }

    public static boolean isSecondHalfGoodString(char c, String input) {
        if(input.length() == 1){
            return c == input.charAt(0);
        }
        int start = 0;
        int totalChars = input.length();
        return isCString(c, input.substring(totalChars/2, totalChars)) &&
                isAgoodString((char)((int)c+1), input.substring(start, totalChars/2));
    }


    public static boolean isCString(char c, String input) {
        if(input.length() == 1){
            return c == input.charAt(0);
        }
        int start =0;
        int end=input.length()-1;
        for(int i=start, j=end; i<j; i++, j--) {
            if(c != input.charAt(i) || c != input.charAt(j) ) {
                return false;
            }
        }
        return  true;
    }
}
