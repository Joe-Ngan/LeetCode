package edu.northeastern.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class leetcode331 {
    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(preorder));

    }

    public static boolean isValidSerialization(String preorder) {
        if(preorder.equals("#"))return true;
        preorder += ",";

        int count = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer>map = new HashMap<>();


        for(int i =0; i<preorder.length(); i++){
            if(preorder.charAt(i)==','){
                if(!stack.isEmpty()){
                    int top = stack.peek();
                    map.put(top, map.getOrDefault(top, 0)+1);
                    if(map.get(top)==2){
                        stack.pop();
                    }
                }

                if(count != -1){
                    stack.push(count);
                }
                count = -1;
            }

            if(preorder.charAt(i)=='#'){
                if(stack.isEmpty()){
                    return false;
                }
            }

            if(Character.isDigit(preorder.charAt(i)) && count == -1){
                if(i>0 &&stack.isEmpty()){
                    return false;
                }
                count = i ;
            }
        }
        return stack.isEmpty();
    }
}
