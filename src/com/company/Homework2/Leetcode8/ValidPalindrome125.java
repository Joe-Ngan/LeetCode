package com.company.Homework2.Leetcode8;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;

        while(l<r){
            while(l<r && !right(s.charAt(l))) l++;
            while(l<r && !right(s.charAt(r))) r--;
            if(!same(s.charAt(l++), s.charAt(r--))) return false;
        }
        return true;
    }

    public static boolean right(char c){
        if((c>=48 && c<=57) || (c>=65 && c<=90) || (c>=97 && c<=122)) return true;
        return false;
    }

    public static boolean same(char a, char b){
        if(a==b)return true;
        if(a!=b && a>=65 && a<=90 && b>=97 && b<=122 && b-a==32)return true;
        if(a!=b && b>=65 && b<=90 && a>=97 && a<=122 && a-b==32)return true;
        return false;

    }
}
