package problem_199;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null)
            return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeNode pre=root;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            //到达层结尾
            if (cur==null){
                res.add(pre.val);
                if (!queue.isEmpty())
                    queue.add(null);
            }else{
                if (cur.left!=null)
                    queue.add(cur.left);
                if (cur.right!=null)
                    queue.add(cur.right);
            }
            pre=cur;
        }
        return res;
    }


}
