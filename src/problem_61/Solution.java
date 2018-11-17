package problem_61;


import com.sun.istack.internal.localization.NullLocalizable;

import java.util.HashSet;

class ListNode {
      int val;
      ListNode next=null;
      ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {

            if (head==null)
                return head;
            ListNode tail=head;
            int i;
            for( i=1;tail.next!=null;i++){
                tail=tail.next;
            }
            int pos=i-k%i;
            ListNode p=head;
            while(--pos!=0){
                p=p.next;
            }
            tail.next=head;
            head=p.next;
            p.next=null;
            return head;
    }

    public static void main(String[] args) {
        HashSet set;
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        listNode1.next=listNode2;
        ListNode head=new Solution().rotateRight(listNode1,3);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}