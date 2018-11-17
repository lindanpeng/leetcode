package problem_143;

import java.util.List;
import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    public ListNode reorderList(ListNode head) {
        if (head==null)
            return  null;
        Stack<ListNode> stack=new Stack<>();
        ListNode p=head,s,newP;
        while(p!=null){
            stack.push(p);
            p=p.next;
        }
        p=newP=head;
        while(p!=null&&!stack.empty()&&p!=stack.peek()){
            s=stack.pop();
            newP=p.next;
            p.next=s;
            s.next=newP;
            p=newP;
            if (p==s) {
                s.next=null;
                return head;
            }
        }
        p.next=null;
        return head;
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        a.next=new ListNode(2);
        a.next.next=new ListNode(3);
        a.next.next.next=new ListNode(4);
        //a.next.next.next.next=new ListNode(5);
        ListNode head=new Solution().reorderList(a);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
