package problem_64;

public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][];
        for(int i=0;i<grid.length;i++)
            dp[i]=new int[grid[i].length];
        int a,b;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i==0&&j==0)
                    dp[i][j]=grid[i][j];
                else{
                    a = i == 0 ? Integer.MAX_VALUE : dp[i - 1][j];
                    b = j == 0 ? Integer.MAX_VALUE : dp[i][j - 1];
                    dp[i][j] = Math.min(a, b) + grid[i][j];
                }
                //System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }

        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] gird={{1,3,1},{1,5,1},{4,2,1}};
        Solution solution=new Solution();
        solution.minPathSum(gird);
    }

}
