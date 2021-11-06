package edu.northeastern.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode368 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,8,9,18,54,90,360};
        System.out.println(largestDivisibleSubset(nums));
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        int max = 0;
        int end = 0;
        for(int i = 1; i<nums.length; i++){
            for(int j =0; j<i; j++){
                if(nums[i]%nums[j]==0){
                    if(dp[j] + 1>=dp[i]){
                        dp[i] = dp[j] + 1;
                        pre[i] = j;

                        max = Math.max(max, dp[i]);
                        if(dp[i]==max){
                            end = i;
                        }
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[end]);
        int previous = pre[end];
        while(previous !=-1){
            list.add(0, nums[previous]);
            previous = pre[previous];
        }
        return list;
    }
}
