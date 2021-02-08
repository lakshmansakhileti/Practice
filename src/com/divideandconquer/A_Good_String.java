package com.divideandconquer;
/** Which checkes a string is a-good or not */
public class A_Good_String {
    public static void main(String[] args) {
        String input = "az";
        char c = 'a';
       int result =  solve(c, input);

        System.out.println("Is input  string  "+input +" is "+c+"- good string? "+ result);
    }

    public static int solve(char c, String input) {
        if(input.length() == 1){
             if(c == input.charAt(0)) {
                 return 0;
             }else {
                 return 1;
             }
        }
        int start = 0;
        int totalChars = input.length();

       return Math.min((getCost(c, input.substring(start, totalChars/2)) +
               solve((char)((int)c+1), input.substring(totalChars/2, totalChars))),
               (getCost(c, input.substring(totalChars/2, totalChars)) +
                       solve((char)((int)c+1), input.substring(start, totalChars/2))));
    }


    public static int getCost(char inputChar, String input) {
        int cost =0;
        for (char c:input.toCharArray()) {
            if(inputChar != c) {
                cost++;
            }
        }
        return cost;
    }
}
