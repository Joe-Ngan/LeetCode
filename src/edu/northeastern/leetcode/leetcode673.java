package edu.northeastern.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode673 {
    public static void main(String[] args) {
        int[] nums = {10,2,5,3,7,101,4,6,5};
        findNumberOfLIS(nums);
    }
    public static int findNumberOfLIS(int[] nums) {
        List<List<int[]>> num = new ArrayList<>();

        //对于第一个元素，加入num
        List<int[]> one = new ArrayList<>();
        // one.add(new int[]{nums[0], 1});
        int[] temp = new int[]{nums[0], 1};
        one.add(temp);
        num.add(one);

        for(int i = 1; i<nums.length; i++){
            List<int[]> last = num.get(num.size()-1);
            int[] lastData = last.get(last.size()-1);
            //对每一个数字进行检验：
            //如果大于当前组list的最后一个数（num.get(num.size()-1))则另开新的list
            if(lastData[0]<nums[i]){
                //另开新的list存数字
                List<int[]> nex = new ArrayList<>();
                int x = ways(num, num.size()-1, nums[i]);
                nex.add(new int[]{nums[i], x});

                num.add(nex);
            }else{
                //找到合适的list并把nums[i]加入其中
                int l = 0;
                int r = num.size()-1;
                while(l<r){
                    int mid = l+(r-l)/2;
                    List<int[]> midList = num.get(mid);
                    int midNum = midList.get(midList.size()-1)[0];
                    if(midNum<nums[i]){
                        l = mid + 1;
                    }else{
                        r = mid;
                    }
                }
                List<int[]> extraList = num.get(l);
                int x = (l==0)? 1 : ways(num, l-1, nums[i]);
                extraList.add(new int[]{nums[i], x});

            }
        }
        int ans = 0;
        List<int[]> finalLast = num.get(num.size()-1);
        for(int[] fin : finalLast){
            ans += fin[1];
        }
        return ans;
    }

    public static int ways(List<List<int[]>> num, int whichone, int index){
        int path = 0;
        //用index与前一个数组的每一个数字进行对比
        //如果index更大，则获得继承其路径数
        List<int[]>last = num.get(whichone);
        for(int[] each : last){
            if(each[0]<index){
                path+=each[1];
            }
        }
        return path;
    }
}
