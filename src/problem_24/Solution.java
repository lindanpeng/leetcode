package problem_24;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode p1=head;
        ListNode p2=head.next;
        ListNode newHead=p1;
        newHead=p2;
       ListNode pre=null;
        while(p2!=null){
            if (pre!=null)
                pre.next=p2;
            p1.next=p2.next;
            p2.next=p1;
            pre=p1;

           if (p1.next!=null){
               p1=p1.next;
               p2=p1.next;
           }else
               break;
        }
        return newHead;
    }
}
