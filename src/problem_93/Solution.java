package problem_93;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private boolean ok(String s){
        if (s.charAt(0)=='0'&&s.length()>1)
            return false;
        try{
            int a=Integer.valueOf(s);
            if (a>=0&&a<=255)
                return  true;
            return false;
        }catch (Exception e){
            return false;
        }

    }
    public void restoreIpAddresses(String s,int index,int k,List<String> result,String cur){
        if (k>4) {
            result.add(cur.substring(0,cur.length()-1));
            return;
        }
        for(int i=index;i<index+3&&i<s.length();i++){
            String temp=s.substring(index,i+1);
            if (ok(temp)&&(s.length()-i-1)<=(4-k)*3){
                restoreIpAddresses(s,i+1,k+1,result,cur+temp+".");
            }

        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<>();
        String cur="";
        restoreIpAddresses(s,0,1,result,cur);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.next();
        List<String> result=new Solution().restoreIpAddresses(input);
        System.out.println(result.size());
    }
}
