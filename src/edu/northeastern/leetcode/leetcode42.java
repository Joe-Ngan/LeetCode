package edu.northeastern.leetcode;

public class leetcode42 {
    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int max = 0;
        int index = 0;
        int l = 0;
        int r = height.length-1;
        int[] array =height.clone();
        for(int i=0; i<height.length; i++){
            max = Math.max(max, height[i]);
            if(max == height[i]){
                index = i;
            }
        }
        findMaxR(height, index, r);
        findMaxL(height, l, index);

        int count = 0;

        for(int i=0; i<array.length; i++){
            count+= height[i]-array[i];
        }
        return count;
    }

    public static void findMaxR(int[] height, int index, int r){
        int p = r;
        if(p<=index){
            return;
        }
        int max = 0;
        int indexNew = 0;
        while(p>index){
            max = Math.max(max, height[p]);
            if(max == height[p]){
                indexNew = p;
            }
            p--;
        }
        for(int i = index+1; i<indexNew; i++){
            height[i]=max;
        }
        findMaxR(height, indexNew, r);
    }

    public static void findMaxL(int[] height, int l, int mid){
        int p = l;
        if(p>=mid){
            return;
        }
        int max = 0;
        int index = 0;
        while(p<mid){
            max = Math.max(max, height[p]);
            if(max == height[p]){
                index = p;
            }
            p++;
        }
        for(int i = index+1; i<mid; i++){
            height[i]=max;
        }
        findMaxL(height, l, index);
    }
}
