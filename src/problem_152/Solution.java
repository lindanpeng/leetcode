package problem_152;

import java.util.concurrent.locks.Lock;

public class Solution {
    public int maxProduct(int[] nums) {
        int max;
        int[] dp=new int[nums.length];
        max=dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if (dp[i-1]>0){
                if (nums[i]>0)
                    dp[i]=dp[i-1]*nums[i];
                else
                    dp[i]=nums[i];
            }
            else{
                if (nums[i]<0)
                    dp[i]=dp[i-1]*nums[i];
                else
                    dp[i]=nums[i];
            }
            if (dp[i]>max)
                max=dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int max=new Solution().maxProduct(new int[]{-2});
        System.out.println(max);
    }
}
