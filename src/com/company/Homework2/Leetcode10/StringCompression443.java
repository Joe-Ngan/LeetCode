package com.company.Homework2.Leetcode10;

public class StringCompression443 {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
        int i = 0;
        int write = 0;
        int n = chars.length;
        //special situation check
        if(n==1) return chars.length;

        while(i<n){
            int idx = i;
            //from i to idx where are all same characters
            while(idx < n && chars[idx]==chars[i]) idx++;
            //length：[i,idx]）
            int len = idx -i;
            //1.write : char
            chars[write++]=chars[i];
            //2.write : num（len>1）
            if(len>1){
                int startNum = write;
                int endNum = startNum;
                //more than 1 digit
                while(len != 0){
                    //mode
                    chars[endNum++]= (char) ((len % 10)+'0');
                    //divide
                    len /= 10;
                }
                //reverse the num
                reverse(chars, startNum, endNum-1);
                //relocate write
                write=endNum;
            }
            //next start idx
            i = idx;
        }
        return write;
    }
    public static void reverse(char[] cs, int start, int end){
        while(start<end){
            char t = cs[start];
            cs[start] = cs[end];
            cs[end] = t;
            start ++;
            end--;
        }
    }
}
