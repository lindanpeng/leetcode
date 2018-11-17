package problem_51;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 */
public class Solution {
    int[] col=new int[100];
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions=new ArrayList<>(n);
        solve(solutions,0,n);
        return solutions;
    }
    private void solve(List<List<String>> solutions,int cur,int n){
        if(cur>=n){
            List<String> solution=new ArrayList<>(n);
            for(int i=0;i<n;i++){
                StringBuilder stringBuilder=new StringBuilder();
                for(int j=0;j<n;j++)
                    if(j!=col[i])
                        stringBuilder.append(".");
                    else
                        stringBuilder.append("Q");
                solution.add(stringBuilder.toString());
            }
            solutions.add(solution);
        }
        for(int i=0;i<n;i++){
            col[cur]=i;
            boolean ok=true;
            for(int j=0;j<cur;j++){
                if (col[j]==col[cur]||cur-col[cur]==j-col[j]||cur+col[cur]==j+col[j]){
                    ok=false;
                    break;
                }
            }
            if(ok)
                solve(solutions,cur+1,n);
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        List<List<String>> lists=solution.solveNQueens(8);
        for(List<String> list:lists){
            for (String str:list){
                System.out.println(str);
            }
        }
    }
}