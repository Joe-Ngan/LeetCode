package com.company.Homework2.Leetcode6;

public class IsomorphicStrings205 {
    public static void main(String[] args) {
        String s = "egg";
        String t = "acd";
        System.out.println(isIsomorphic(s, t));
    }

    private static boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        int[] counts = new int[256];
        int[] countt = new int[256];

        for(int i = 0; i<s.length(); i++){
            if(counts[chars[i]] != countt[chart[i]])return false;
            counts[chars[i]] = i +1;
            countt[chart[i]] = i +1;
        }
        return true;
    }
}
