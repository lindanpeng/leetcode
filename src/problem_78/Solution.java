package problem_78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>(1<<nums.length);
        for (int i=0;i<1<<nums.length;i++){
            LinkedList<Integer> list=new LinkedList<>();
            int k=nums.length-1;
            int temp=i;
            while(temp!=0){
                if ((temp&1)==1){
                    list.addFirst(nums[k]);
                }
                k--;
                temp=(temp>>1);
            }
            result.add(list);
        }
        return result;
    }
    private void subsets(int[] nums,List<List<Integer>> result,List<Integer> c,int cur){
        result.add(new ArrayList<>(c));
        if (cur>=nums.length)
            return;
        for (int i=cur;i<nums.length;i++){
            c.add(nums[i]);
            subsets(nums,result,c,i+1);
            c.remove(c.size()-1);
        }
    }
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result=new ArrayList<>(1<<nums.length);
        List<Integer> list=new ArrayList<>();
        subsets(nums,result,list,0);
        return result;
    }
    public static void main(String[] args) {
        new Solution().subsets2(new int[]{1,2,3});
    }
}
