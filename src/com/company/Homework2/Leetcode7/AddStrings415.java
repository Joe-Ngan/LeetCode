package com.company.Homework2.Leetcode7;

public class AddStrings415 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "12";
        System.out.println(addStrings(num1, num2));
    }

    private static String addStrings(String num1, String num2) {
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;

        int carry = 0;

        int one;
        int two;
        int sum;

        StringBuffer sb = new StringBuffer();
        while(n1>=0 || n2>=0){
            one = n1>=0 ? num1.charAt(n1--) -'0' : 0;
            two = n2>=0 ? num2.charAt(n2--) -'0' : 0;
            sum = (one + two + carry) % 10;
            carry = (one + two + carry) > 9 ? 1 : 0;

            sb.insert(0, Integer.toString(sum));
        }
        if(carry != 0) sb.insert(0, Integer.toString(carry));

        return sb.toString();

    }
}
