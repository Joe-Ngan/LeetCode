package edu.northeastern.leetcode;

public class leetcode55 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        boolean[] reachable = new boolean[nums.length];
        reachable[nums.length-1]= true;
        for(int i = nums.length-2; i>=0; i--){
            int x = i + 1;
            while(reachable[x] != true && x<nums.length){
                x++;
            }
            reachable[i]=(nums[i]>=x-i)? true : false;
        }
        return reachable[0];
    }

}
