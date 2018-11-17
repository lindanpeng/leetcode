package problem_322;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        dp[0]=0;
        int min;
        for (int i=1;i<=amount;i++){
            min=Integer.MAX_VALUE;
            for (int j=0;j<coins.length;j++){
                int k=1;
                while(coins[j]*k<=i) {
                    if (dp[i-k*coins[j]]!=-1&&dp[i - k * coins[j]] + k < min) {
                        min = dp[i - k * coins[j]] + k;
                    }
                    k++;
                }
                dp[i]=min==Integer.MAX_VALUE?-1:min;
            }

        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int result=new Solution().coinChange(new int[]{2,5},3);
        System.out.println(result);
    }
}
