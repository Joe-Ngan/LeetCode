package edu.northeastern.leetcode;

public class leetcode300 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];

        int i = 0;
        int j = 0;
        tails[j] = nums[i++];

        while(i<nums.length){
            if(nums[i]<=tails[j]){
                //如果接下来的值nums[i]比前值ans[j]要小，则覆盖[0,j-1]间比nums[i]要大的最小值;
                int l = 0;
                int r = j;
                //二分查找
                while(l<r){//等于意味着有一个元素也进行一次搜索。最后的目标必然比nums[i]大，会不断循环r=mid
                    int mid = l+(r-l)/2;
                    if(tails[mid]<nums[i]){
                        l=mid+1;
                    }else{
                        r=mid;//mid有天然的左倾趋势（2，3得2）。如果想要此mid，请不要放走！
                    }
                }
                //最后必然是l=r
                tails[l]= nums[i];
            }else{
                //如果接下来的值nums[i]比前值ans[j]要大，则另起炉灶，ans[j+1]=nums[i];
                tails[++j] = nums[i];
            }
            i++;
        }
        return j;
    }
}
