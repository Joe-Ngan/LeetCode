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
        //特殊性检验
        if(n==1) return chars.length;

        while(i<n){
            int idx = i;
            //从i开始，找到同字符的终点idx
            while(idx < n && chars[idx]==chars[i]) idx++;
            //长度为idx-i（区间为：[i,idx]）
            int len = idx -i;
            //1.写字符
            chars[write++]=chars[i];
            //2.写数字（若长度>1）
            if(len>1){
                int startNum = write;
                int endNum = startNum;
                //数字是多位数
                while(len != 0){
                    //取最小位数
                    chars[endNum++]= (char) ((len % 10)+'0');
                    //除10取次小位数
                    len /= 10;
                }
                //将长度翻转
                reverse(chars, startNum, endNum-1);
                //下次书写位置即为end
                write=endNum;
            }
            //下一个起始点：从i开始，找到同字符的终点
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
