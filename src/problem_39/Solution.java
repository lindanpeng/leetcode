package problem_39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public void combinationSum(int[] candidates,int target,List<List<Integer>> result,List<Integer> cur,int curSum,int index){
        long test=01;
        float f=-412;
        double d=0x123;
        if (curSum==target){
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i=index;i<candidates.length;i++){
            if (curSum+candidates[i]<=target) {
                cur.add(candidates[i]);
                combinationSum(candidates,target,result,cur,curSum+candidates[i],i);
                cur.remove(cur.size()-1);
            }
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        combinationSum(candidates,target,res,cur,0,0);
        return res;
    }
    public static void main(String[] args) {

    }
}
