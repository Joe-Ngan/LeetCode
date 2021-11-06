package edu.northeastern.leetcode;

public class leetcode1713 {
    public static void main(String[] args) {
        int[] target = {5,1,3};
        int[] arr = {9,4,2,3,4};
        System.out.println(minOperations(target, arr));
    }
    public static int minOperations(int[] target, int[] arr) {
        int n = target.length;
        int m = arr.length;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                dp[i][j] = (arr[m-1]==target[n-1])? dp[i-1][j-1]+1: Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int ans =  n-dp[m][n];
        return ans;
    }
}
