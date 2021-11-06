package edu.northeastern.leetcode;

public class leetcode367 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(5));
    }
    public static boolean isPerfectSquare(int num) {
        int l = 1;
        int r = num;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(num/mid == mid && num%mid ==0){
                return true;
            }else if(num/mid < mid){
                r = mid-1;
            }else if(num/mid > mid){
                l = mid+1;
            }
        }
        return false;
    }
}
