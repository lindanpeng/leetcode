package problem_115;

public class Solution {
//    public int numDistinct(String s, String t) {
//            numDistinct(s,t,0,0);
//    }
//    private int[][] sign=new int[1000][1000];
//    private int numDistinct(String s,String t,int cur,int k ){
//        if (sign[cur][k]!=-1){
//            return sign[cur][k];
//        }
//        if (k>=t.length()){
//            sign[cur][k]=1;
//            for (int i=cur;i<s.length();i++)
//            return 1;
//        }
//        int cnt=0;
//        for (int i=cur;i<s.length();i++){
//            if (s.charAt(i)==t.charAt(k)){
//                cnt+=numDistinct(s,t,i+1,k+1);
//            }
//        }
//        return cnt;
//    }
//
//    public static void main(String[] args) {
//        int n=new Solution().numDistinct("rabbbit","rabbit");
//        System.out.println(n);
//    }
}
