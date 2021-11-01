package edu.northeastern.oaset;

import java.util.ArrayList;
import java.util.List;

public class demo696CountBinarySubstrings {
    public static void main(String[] args) {
        System.out.println();
    }

    public int countBinarySubstrings(String s) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for(int i = 0; i<s.length(); i++){
            if(i>0 && s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            if(i>0 && s.charAt(i)!=s.charAt(i-1)){
                list.add(count);
                count = 1;
            }
            if(i==s.length()-1){
                list.add(count);
            }
        }
        for(int i = 0; i<list.size(); i++){
            if(i>0 && list.get(i)>list.get(i-1)){
                ans += list.get(i-1);
            }
            if(i>0 && list.get(i)<=list.get(i-1)){
                ans += list.get(i);
            }
        }

        return ans;
    }
}
