package edu.northeastern.oaset;

import java.util.Arrays;
import java.util.Comparator;

public class demo1048LongestStringChain {
    private static int ans = 0;
    public static void main(String[] args) {
        String[] words = new String[]{"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));
    }


    public static int longestStrChain(String[] words) {
    Arrays.sort(words,Comparator.comparingInt(String::length));
    int[] dp =new int[words.length];

        for(int i=0; i<words.length; i++){
        for(int j= i+1; j<words.length; j++){
            if((words[j].length() - words[i].length()) == 1 && predecessor(words[i], words[j])){
                dp[j] = Math.max(dp[i]+1, dp[j]);
                ans = Math.max(ans, dp[j]);
            }
        }
    }
        return ans+1;
}

    public static boolean predecessor(String s, String str){
        int i = 0, j = 0, flag = 0;
        while(i<s.length() && j<str.length()){
            if((s.charAt(i) == str.charAt(j))){
                i++;
                j++;
            }else{
                j++;
                flag++;
            }

            if(flag>=2)return false;
        }
        return true;
    }
//    public static int longestStrChain(String[] words) {
//        Arrays.sort(words,Comparator.comparingInt(String::length));
//
//        for(int i = 0; i<words.length; i++){
//            bts(words, words[i], 1, i+1);
//        }
//        return ans;
//    }
//
//    public static void bts(String[] words, String s, int count, int index){
//        ans = Math.max(ans, count);
//
//        if(index==words.length){
//            return;
//        }
//
//        for(int i = index; i<words.length; i++){
//            if((words[i].length() - s.length()) == 1 && predecessor(s, words[i])){
//                bts(words, words[i], count+1, i);
//            }
//        }
//    }
//
//    public static boolean predecessor(String s, String str){
//        int i = 0, j = 0, flag = 0;
//        while(i<s.length() && j<str.length()){
//            if((s.charAt(i) == str.charAt(j))){
//                i++;
//                j++;
//            }else{
//                j++;
//                flag++;
//            }
//
//            if(flag>=2)return false;
//        }
//        return true;
//    }
}

