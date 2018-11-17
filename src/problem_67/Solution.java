package problem_67;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        int s=0,c=1;
        int[] result=Arrays.copyOf(digits,digits.length);
        for(int i=result.length-1;i>=0;i--){
            s=(result[i]+c)%10;
            c=(result[i]+c)/10;
            result[i]=s;
            if (c==0)
                break;
        }
        if (c!=0){
            int[] newResult=new int[result.length+1];
            System.arraycopy(result,0,newResult,1,result.length);
            newResult[0]=c;
            return newResult;
        }
        else{
            return result;
        }
    }
    public static void main(String[] args) {
        int[] result=new Solution().plusOne(new int[]{9,9,9});
        for (int i=0;i<result.length;i++)
            System.out.print(result[i]);
    }
}
