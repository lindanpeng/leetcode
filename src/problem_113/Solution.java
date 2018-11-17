package problem_113;

import com.sun.deploy.panel.TreeBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null)
            return new LinkedList<>();
        List<List<Integer>> list=new LinkedList<>();
        if (root.left==null&&root.right==null&&sum-root.val==0){
            List<Integer> ans=new ArrayList<>();
            ans.add(root.val);
            list.add(ans);
            return list;
        }
        List<List<Integer>> list1=pathSum(root.left,sum- root.val);
        List<List<Integer>> list2=pathSum(root.right,sum- root.val);
        if (list1!=null&&list1.size()!=0){
            for (List<Integer> l:list1){
                l.add(0,root.val);
            }
            list.addAll(list1);
            double oD=1;
        }
        if (list2!=null&&list2.size()!=0){
            for (List<Integer> l:list2){
                l.add(0,root.val);
            }
            list.addAll(list2);
        }
        return list;
    }
//    public  findPathSum(TreeNode root,int sum,List<Integer> list){
//        if (root==null)
//            return;
//        if(root.left==null&&root.right==null&&sum==0){
//            list.add(root.val);
//            result.add(list);
//            return;
//        }
//        findPathSum(root.left,sum,list)
//        findPathSum(root.right,sum);
//    }
    public static void main(String[] args) {

    }
}

