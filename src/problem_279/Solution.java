package problem_279;

public class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        int min;
        for (int i=1;i<=n;i++){
                min = Integer.MAX_VALUE;
                for (int j = 1; j * j <=i; j++) {
                    if (dp[i - j * j] + 1 < min) {
                        min = dp[i - j * j] + 1;
                    }
            }
            dp[i]=min;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int result=new Solution().numSquares(13);
        System.out.println(result);
    }
}
