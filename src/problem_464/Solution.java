package problem_464;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int sum(List<Integer> list){
        int sum=0;
        for (Integer i:list){
            sum+=i;
        }
        return sum;
    }

    /**
     *
     * @param ints
     * @param desiredTotal
     * @param turn 0代表玩家1，1代表玩家2
     * @return
     */
    public boolean canIWin(List<Integer> ints,int desiredTotal,int turn){
        int s=sum(ints);
        if (s<desiredTotal)
            return false;
        if (ints.get(ints.size()-1)>=desiredTotal){
            return turn==0;
        }
        desiredTotal-=ints.get(0);
        ints.remove(0);
        return canIWin(ints,desiredTotal,1-turn);
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        List<Integer> ints=new ArrayList<>();
        for (int i=1;i<maxChoosableInteger;i++)
            ints.add(i);
        return  canIWin(ints,desiredTotal,1);
    }

    public static void main(String[] args) {
        boolean res=new Solution().canIWin(5,13);
        System.out.println(res);
    }
}
