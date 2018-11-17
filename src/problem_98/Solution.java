package problem_98;

class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    private int getMaxValue(TreeNode root){
        if (root==null)
            return -1;
        TreeNode p=root;
        while(p.right!=null)
            p=p.right;
        return p.val;
    }
    private int getMinValue(TreeNode root){
        if (root==null)
            return -1;
        TreeNode p=root;
        while(p.left!=null)
            p=p.left;
        return p.val;
    }
    public boolean isValidBST(TreeNode root) {
        if (root==null)
            return true;
        boolean l=true,r=true;
        if (root.left!=null)
            l=getMaxValue(root.left)<root.val&&isValidBST(root.left);

       if (root.right!=null)
           r=getMinValue(root.right)>root.val&&isValidBST(root.right);
       return l&&r;
    }
}
