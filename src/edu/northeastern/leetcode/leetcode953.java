package edu.northeastern.leetcode;

import java.util.Arrays;

public class leetcode953 {
    public static void main(String[] args) {
        String[] words = new String[]{"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }
    public static boolean isAlienSorted(String[] words, String order) {
        for(int j = 1; j<words.length; j++){
            int i = 0;
            while(i<= words[j-1].length() && i<= words[j].length()){
                if(i== words[j].length() || i== words[j-1].length()){
                    if(words[j].length()<words[j-1].length()){
                        return false;
                    }else{
                        break;
                    }
                }
                char former = words[j-1].charAt(i);
                char latter = words[j].charAt(i);
                int formOrder = order.indexOf(former);
                int latterOrder = order.indexOf(latter);
                if(formOrder==latterOrder){
                    i++;
                }else if(formOrder<latterOrder){
                    break;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}

