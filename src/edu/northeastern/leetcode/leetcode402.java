package edu.northeastern.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode402 {
    public static void main(String[] args) {
        String num ="112";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }
    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i<num.length(); i++){
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        while(sb.length()>=1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length()>=1? sb.toString() : "0";
    }
}
