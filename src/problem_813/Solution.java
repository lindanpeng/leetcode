package problem_813;

import java.util.concurrent.CyclicBarrier;

public class Solution {

    public double largestSumOfAverages(int[] A, int K) {
        double[][]  pre=new double[A.length][A.length];
        pre[0][0]=A[0];
        for (int i=1;i<A.length;i++){
            pre[0][i]=A[i]+pre[0][i-1];
        }
        for (int i=0;i<A.length;i++){
            for (int j=i;j<A.length;j++){
               pre[i][j]=pre[0][j]-pre[0][i]+A[i];
            }
        }
        for (int i=0;i<A.length;i++){
            for (int j=i;j<A.length;j++){
                pre[i][j]=pre[i][j]/(j-i+1);
            }
        }
        double max;
        double[][] dp=new double[A.length][K+1];
      for(int i=0;i<A.length;i++){
            for (int j=1;j<=K;j++){
                if (j==1){
                    dp[i][j]=pre[0][i];
                }
                else {
                    max = 0;
                    for (int t = 0; t <i; t++) {
                        if (dp[t][j - 1] + pre[t + 1][i] > max)
                            max = dp[t][j - 1] + pre[t + 1][i];
                    }
                    dp[i][j] = max;
                }
            }
      }
        return dp[A.length-1][K];
    }
//    private void backtrack(int cur,int rest,double sum){
//        if (rest==0){
//            sum+=pre[cur][n-1];
//            if (sum>result)
//                result=sum;
//            return;
//        }
//        for (int i=cur+1;i<n;i++){
//            backtrack(i,rest-1,sum+pre[cur][i-1]);
//        }
//    }

    public static void main(String[] args) {
        double result=new Solution().largestSumOfAverages(new int[]{4663,3020,7789,1627,9668,1356,4207,1133,8765,4649,205,6455,8864,3554,3916,5925,3995,4540,3487,5444,8259,8802,6777,7306,989,4958,2921,8155,4922,2469,6923,776,9777,1796,708,786,3158,7369,8715,2136,2510,3739,6411,7996,6211,8282,4805,236,1489,7698},27);
      //  double result=new Solution().largestSumOfAverages(new int[]{9,1,2,3,9},3);
        System.out.println(result);
    }
}
