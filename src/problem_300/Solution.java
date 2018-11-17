package problem_300;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
       int max=0;
       for (int i=0;i<nums.length;i++){
           for (int j=0;j<i;j++){
               if (nums[i]>nums[j]){
                   dp[i]=Math.max(dp[i],dp[j]+1);
               }
           }
           System.out.println(dp[i]);
           if (dp[i]>max)
               max=dp[i];
       }
       return max;
    }
    public static void main(String[] args) {
       int max= new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(max);
    }
}
