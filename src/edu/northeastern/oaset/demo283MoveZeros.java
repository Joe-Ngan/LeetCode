package edu.northeastern.oaset;

public class demo283MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,0,8,9,3,0};
        moveZeroes(nums);
        System.out.println(nums);
    }
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for(int num: nums){
            if (num != 0){
                nums[index++] = num;
            }
        }
        while(index<=nums.length-1){
            nums[index++]=0;
        }
    }

}
