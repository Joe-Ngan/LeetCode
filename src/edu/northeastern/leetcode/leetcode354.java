package edu.northeastern.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode354 {

    public static void main(String[] args) {
        int[][] envelopes = {{1,1},{2,3},{3,7},{4,5},{4,8},{6,9}};
        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[]b){
                return (a[0]==b[0])? (a[0]-b[0]) : (a[1]-b[1]);
            }
        });

        int[] dp = new int[envelopes.length];
        int j = 0;
        dp[0] = envelopes[0][1];
        for(int i = 1; i<dp.length; i++){
            if(envelopes[i][1]>dp[j]){
                j++;
                dp[j] = envelopes[i][1];
            }else{
                int l =0;
                int r =j;
                while(l<r){
                    int mid = l+(r-l)/2;
                    if(dp[mid]<envelopes[i][1]){
                        l = mid + 1;
                    }else{
                        r = mid;
                    }
                }
                dp[l] = envelopes[i][1];
            }
        }
        return j+1;
    }
}
