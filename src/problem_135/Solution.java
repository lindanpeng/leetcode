package problem_135;

import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int[] dp=new int[ratings.length];
        Arrays.fill(dp,-1);
        for (int i=1;i<ratings.length;i++){
           if (ratings[i]<ratings[i-1]){
               dp[i]=dp[i-1]-1;
           }else if (ratings[i]>ratings[i-1]){
               dp[i-1]=dp[i-1]-1;
           }else{
               dp[i]=-1;
           }
        }
        int sum=0;
        for (int i=0;i<dp.length;i++){
            sum+=dp[i];
        }
        return -sum;

    }

    public static void main(String[] args) {
        int result=new Solution().candy(new int[]{1,2,2});
        System.out.println(result);
    }
}
