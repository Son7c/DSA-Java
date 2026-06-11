/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode revLL(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = revLL(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        int count=1;
        ListNode temp=head,start=head,next=null;
        List<ListNode> list=new ArrayList<>();
        List<ListNode> revL=new ArrayList<>();
        while(temp!=null&&temp.next!=null){
            if(count%k==0){
                list.add(start);
                next=temp.next;
                temp.next=null;
                start=next;
                count++;
                temp=next;
            }else{
                count++;
                temp=temp.next;
            }
        }
        if(count%k==0) list.add(start);
        for(int i=0;i<list.size();i++){
            ListNode rev=revLL(list.get(i));
            revL.add(rev);
        }
        boolean flag=false;
        for(int i=0;i<list.size()-1;i++){
            if(i==0){
                head=revL.get(i);
                flag=true;
            }
            list.get(i).next=revL.get(i+1);
        }
        if(count%k!=0) list.get(list.size()-1).next=start;
        if(!flag){
            head=revL.get(0);
        }
        return head;
    }
}