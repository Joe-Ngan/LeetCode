package edu.northeastern.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode581 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(findUnsortedSubarray(nums));
    }
    public static int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        int num = Integer.MIN_VALUE;
        int large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                index = stack.pop();
                large = Math.max(large, index);
                small = Math.min(small, index);
                num = Math.max(num, nums[index]);
            }
            if(nums[i]<num){
                large = Math.max(large, i);
                small = Math.min(small, i);
            }else{
                stack.push(i);
            }

        }
        return (large==Integer.MIN_VALUE && small==Integer.MAX_VALUE) ? 0 : large-small+1;
    }
}
