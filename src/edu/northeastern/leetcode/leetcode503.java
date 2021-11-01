package edu.northeastern.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class leetcode503 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,3,5,4,3,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        //find the climax
        int max = nums[0];
        int maxIndex = 0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(nums[i], max);
            if(nums[i] == max){
                maxIndex = i;
            }
        }

        int[] count = new int[nums.length];
        Deque<Integer> stack1 = new ArrayDeque<>();

        //start from the climax+1
        for(int i = maxIndex+1; i<nums.length; i++){
            while(!stack1.isEmpty() && nums[stack1.peek()]<nums[i]){
                int index = stack1.pop();
                count[index] = nums[i];
            }
            stack1.push(i);
        }
        for(int i = 0; i<maxIndex+1; i++){
            while(!stack1.isEmpty() && nums[stack1.peek()]<nums[i]){
                int index = stack1.pop();
                count[index] = nums[i];
            }
            stack1.push(i);
        }

        while(!stack1.isEmpty()){
            count[stack1.pop()]=-1;
        }
        return count;
    }

}
