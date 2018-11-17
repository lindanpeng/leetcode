package problem_307;

class NumArray {
    class Node{
        int left;
        int right;
        Node lc;
        Node rc;
        int sum;

    }
    private Node root;
    public NumArray(int[] nums) {
        if (nums==null||nums.length==0)
            return;
        root=build(0,nums.length-1,nums);
    }

    public void update(int i, int val) {
        update(i,val,root);
    }
    private void update(int i,int val,Node t){
        if (t.left==i&&t.right==i){
            t.sum=val;
        }else{
            if (i<=t.right&&i>=t.left) {
                int m = (t.left + t.right) >> 1;
                if (i <= m)
                    update(i, val, t.lc);
                else
                    update(i, val, t.rc);
                t.sum=t.lc.sum+t.rc.sum;
            }
        }
    }
    public int sumRange(int i, int j) {
        return sumRange(i,j,root);
    }
    private int sumRange(int i,int j,Node t){
        int m=(t.left+t.right)>>1;
        if (t.left==t.right)
            return t.sum;
        if (j<=m)
            return sumRange(i,j,t.lc);
        else if (i>m)
            return sumRange(i,j,t.rc);
        else
            return sumRange(i,m,t.lc)+sumRange(m+1,j,t.rc);
    }
    private Node build(int l,int r,int[] nums){
        Node node=new Node();
        node.left=l;
        node.right=r;
        if(l==r){
            node.sum=nums[l];
        }
        else{
            int m=(l+r)>>1;
            Node leftChild=build(l,m,nums);
            Node rightChild=build(m+1,r,nums);
            node.sum=leftChild.sum+rightChild.sum;
            node.lc=leftChild;
            node.rc=rightChild;
        }
        return node;
    }

    public static void main(String[] args) {
        NumArray numArray=new NumArray(new int[]{1,3,5,6});
        System.out.println(numArray.sumRange(2,3));
    }
}
