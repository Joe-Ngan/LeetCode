package edu.northeastern.leetcode;

public class leetcode978 {
    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        int ans = maxTurbulenceSize(arr);
        System.out.println(ans);
    }
    public static int maxTurbulenceSize(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        boolean BiggerThanPre = true;
        int ans = 0;
        if(arr[0]<arr[1]){
            BiggerThanPre = true;
        }else{
            BiggerThanPre = false;
        }

        for(int i = 1; i<arr.length; i++){
            if(arr[i]==arr[i-1]){
                dp[i] = 1;
                continue;
            }

            if(BiggerThanPre == true){
                if((arr[i-1]<arr[i])){
                    dp[i] = dp[i-1] + 1;
                    BiggerThanPre = false;
                }else{
                    dp[i] = 2;
                }
            }else{
                if((arr[i-1]>arr[i])){
                    dp[i] = dp[i-1] + 1;
                    BiggerThanPre = true;
                }else{
                    dp[i] = 2;
                }
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
