package problem_153;

import java.util.BitSet;

public class Solution {

    public int findMin(int[] nums) {

        int start=0,end=nums.length-1;
        int middle;
        while(start<end){
            middle=(start+end)>>1;
            if (nums[middle]>nums[end])
                start=middle+1;
            else
                end=middle;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int result=new Solution().findMin(new int[]{7,8,9,10,11,12,13,14,0,1,2,3,4,5});
        System.out.println(result);
    }
}
