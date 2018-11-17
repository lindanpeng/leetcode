package problem_44;

public class Solution {
    public boolean isMatch(String s,String p){
        if (s==null||p==null)
            return false;
        StringBuilder sb = new StringBuilder();
         for (int i=0;i<p.length();i++){
             if (p.charAt(i)!='*')
                 sb.append(p.charAt(i));
             else{
                 if (i==0)
                     sb.append("*");
                 else if (i!=0&&p.charAt(i-1)!='*')
                     sb.append("*");
             }
         }
        return isMatch2(s,sb.toString());
    }
    private boolean isMatch2(String s, String p) {
        if (p.length()==0&&s.length()>0)
            return false;
        if (p.length()==0&&s.length()==0)
            return true;
        if (s.length()>0){
            String sSub=s.substring(1);
            String pSub=p.substring(1);
            if (p.charAt(0)=='*'){
                return isMatch(sSub,p)||
                        isMatch(s,pSub)||
                        isMatch(sSub,pSub);
            }
            else if (p.charAt(0)==s.charAt(0)||p.charAt(0)=='?'){
                return isMatch(sSub,pSub);
            }
            return false;
        }else{
            if (p.charAt(0)=='*'){
                return isMatch(s,p.substring(1));
            }
                return false;
        }

    }
    public boolean isMatch3(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];   // dp[i] maps to dp[i][j], where i is the length of s, j is the length of j
        char[] sStr = s.toCharArray();
        char[] pStr = p.toCharArray();
        dp[0][0]=true;
        for (int i=0;i<=sStr.length;i++){
            for (int j=1;j<=pStr.length;j++) {
                if (i == 0) {
                    if (pStr[j-1]=='*')
                        dp[i][j]=true;
                    else
                        break;
                } else {
                    if (pStr[j - 1] == '*') {
                        dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        if (sStr[i - 1] == pStr[j - 1] || pStr[j - 1] == '?') {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else
                            dp[i][j] = false;
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {
      //  String[] arr="*ab***ba**b*b*aaab*b".split("\\*");
        boolean res=new Solution().isMatch3("acdcb","a*c?b");
        System.out.println(res);
    }
}
