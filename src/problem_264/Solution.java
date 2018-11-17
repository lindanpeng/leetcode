package problem_264;

import java.util.HashMap;

public class Solution {
    public int min3(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
    public int nthUglyNumber(int n) {
        if (n<=0)
            return 0;
        int[] uglyNumbers=new int[n];
        uglyNumbers[0]=1;
        int nextUglyIndex=1;
        int i=0,j=0,k=0;
        while(nextUglyIndex<n){
            int min=min3(uglyNumbers[i]*2,uglyNumbers[j]*3,uglyNumbers[k]*5);
            uglyNumbers[nextUglyIndex]=min;
            while (uglyNumbers[i]*2<=uglyNumbers[nextUglyIndex])
                i++;
            while (uglyNumbers[j]*3<=uglyNumbers[nextUglyIndex])
                j++;
            while (uglyNumbers[k]*5<=uglyNumbers[nextUglyIndex])
                k++;
            nextUglyIndex++;
        }
        return uglyNumbers[n-1];
    }

    public static void main(String[] args) {
        HashMap map=new HashMap();
        int res=new Solution().nthUglyNumber(10);
        System.out.println(res);
    }
}
