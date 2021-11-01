package edu.northeastern.oaset;

public class demo1347MinimumNumberofStepstoMakeTwoStringsAnagram {
    public static void main(String[] args) {
        String s = "family";
        String t = "friend";
        System.out.println(minSteps(s, t));
}

public static int minSteps(String s, String t) {
    int n = s.length();
    int count = 0;
    int[] letters = new int[26];
    for(int i = 0; i<n; i++){
        letters[s.charAt(i)-'a']++;
    }
    for(int i = 0; i<n; i++){
        letters[t.charAt(i)-'a']--;
        if(letters[t.charAt(i)-'a']<0){
            count++;
        }
    }
    return count;
}
}
