package edu.northeastern.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode1673 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,6};
        int k = 2;
        mostCompetitive(nums, k);
    }
    public static int[] mostCompetitive(int[] nums, int k) {
        int p = nums.length-k;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i<nums.length; i++){
            while(!stack.isEmpty() && p>0 && stack.peek()>nums[i]){
                stack.pop();
                p--;
            }
            stack.push(nums[i]);
        }
        while(!stack.isEmpty() && p>0){
            stack.pop();
            p--;
        }
        int[] ans = new int[k];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}
