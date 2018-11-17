package problem_86;
class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (null==head)
            return null;
        ListNode lessPart=null,gePart=null,p=null,p1=null,p2=null;
        p=head;
        while(p!=null){
            if (p.val<x) {
                if (lessPart == null) {
                    lessPart = p;
                    p1 = lessPart;
                } else {
                    p1.next = p;
                    p1 = p1.next;
                }
            }
            else{
                    if (gePart==null){
                        gePart=p;
                        p2=gePart;
                    }else{
                        p2.next=p;
                        p2=p2.next;
                    }
                }
                p=p.next;
            }
        if (p1!=null)
            p1.next=gePart;
        else{
            lessPart=gePart;
        }
        if (p2!=null)
            p2.next=null;
        return lessPart;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(0);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(2);
//        head.next.next.next.next=new ListNode(5);
//        head.next.next.next.next.next=new ListNode(2);
        ListNode p=new Solution().partition(head,3);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
}