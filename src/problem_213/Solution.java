package problem_213;

public class Solution {
    private int rob(int[] nums,int start,int end) {

        int[] dp=new int[nums.length];
        dp[start]=nums[start];
        for (int i=start+1;i<=end;i++){
            if (i==start+1)
                dp[i] = nums[start+1]>dp[start]?nums[start+1]:dp[start];
            else
                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);

        }
        return dp[end];
    }
    public int rob(int[] nums){
        if (nums==null||nums.length<=0)
            return 0;
        if (nums.length==1)
            return nums[0];
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }
    public static void main(String[] args) {
        int[] arr={0};
        int s=new Solution().rob(arr);
        System.out.println(s);
    }
}
