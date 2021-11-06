package edu.northeastern.leetcode;

import java.util.Arrays;

public class leetcode1218 {
    public static void main(String[] args) {
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int difference = -2;
        longestSubsequence(arr, difference);

    }
    public static int longestSubsequence(int[] arr, int difference) {
        int[] gap = new int[arr.length-1];
        for(int i = 0; i<gap.length; i++){
            gap[i] = arr[i+1] - arr[i];
        }
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int pre = dp.length-1;
        int count = 0;
        int start = dp.length-1;
        while(start>=0){
            if(dp[start]!=Integer.MIN_VALUE){
                start--;
                continue;
            }
            dp[start] = 1;
            count = 0;
            pre=start;
            for(int i = start-1; i>=0; i--){
                count += gap[i];
                if(count == difference){
                    dp[i] = Math.max(dp[i], dp[pre]+1);
                    count = 0;
                    pre = i;
                }
            }
            start--;
        }
        int ans = 0;
        for(int num : dp){
            ans = Math.max(num, ans);
        }
        return ans;
    }
}
