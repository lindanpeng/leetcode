package problem_392;

public class Solution {
    public boolean isSubsequence(String s,String t){
        for (int i=0,init=0,j;i<s.length();i++){
            for (j=init;j<t.length();j++){
                if (s.charAt(i)==t.charAt(j)){
                    break;
                }
            }
            if (j==t.length())
                return false;
            init=j+1;
        }
        return true;
    }
    public static void main(String[] args) {
        boolean result=new Solution().isSubsequence("a","");
        System.out.println(result);
    }
}
