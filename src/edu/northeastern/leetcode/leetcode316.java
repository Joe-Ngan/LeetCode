package edu.northeastern.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leetcode316 {
    public static void main(String[] args) {
        String s = "abacb";
        System.out.println(removeDuplicateLetters(s));
    }
    public static String removeDuplicateLetters(String s) {
        int len = s.length();

        Deque<Character> stack = new ArrayDeque<>();
        boolean[] inside = new boolean[26];
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            //入栈条件：栈中不存在
            if (inside[c - 'a']) {
                continue;
            }
            //出栈条件：栈顶大字母，且会再出现
            while (!stack.isEmpty() && (stack.peek() - 'a') > (c - 'a') && last[stack.peek() - 'a'] > i) {
                inside[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            inside[c - 'a'] = true;

            i++;
        }

        StringBuffer sb = new StringBuffer();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
