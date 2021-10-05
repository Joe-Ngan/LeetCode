package com.company.Homework2.Leetcode2;

public class ShortestWordDistance243 {
    public static void main(String[] args) {
        String[] wordsOfDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = new String("coding");
        String word2 = new String("practice");
        System.out.println(shortestWordDistance(wordsOfDict, word1, word2));

    }

    public static int shortestWordDistance(String[] wordsOfDict, String word1, String word2){
        int i = 0;
        int j = 0;
        int n = wordsOfDict.length;
        int ans = Integer.MAX_VALUE;

        while(i<n || j<n){
            while(i<n && !wordsOfDict[i].equals(word1)){
                i++;
            }
            while(j<n && !wordsOfDict[i].equals(word2)){
                j++;
            }
            ans = Math.min(ans, Math.abs(i-j));
            i++;
            j++;
        }

        return ans;
    }

}
