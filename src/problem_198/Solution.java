package problem_198;

public class Solution {
        public int rob(int[] nums) {
                if (nums==null||nums.length==0)
                    return 0;
                int[] dp=new int[nums.length];
                dp[0]=nums[0];
                for (int i=1;i<dp.length;i++){
                    if (i==1)
                        dp[i] = nums[1]>dp[0]?nums[1]:dp[0];
                    else
                        dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);

                }
                return dp[dp.length-1];
        }
    public static void main(String[] args) {
            int[] arr={1,3,1,6};
        int s=new Solution().rob(arr);
        System.out.println(s);
    }
}
