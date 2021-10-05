package com.company.Homework2.Leetcode9;

public class ReverseWordsInAString151 {
    public static void main(String[] args) {
        String s =  "the sky is blue";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {

        int r = s.length();
        int l;

        StringBuffer sb = new StringBuffer();
        while(r>0){
            while(r>0 && s.charAt(r-1)==32) r--;
            l = r;
            while(l>0 && s.charAt(l-1)!=32) l--;
            sb.append(s.substring(l,r));
            sb.append(" ");
            r = l;
        }
        if(s.charAt(0)==32){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.deleteCharAt(sb.length()-1);




        return sb.toString();
    }
}
