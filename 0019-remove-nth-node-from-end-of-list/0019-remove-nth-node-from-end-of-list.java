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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        if(head.next.next==null){
            if(n==1){
                head.next=null;
                return head;
            }
            head=head.next;
            return head;
        }
        int length=1;
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }
        int idx=length-n;
        if(idx==0) return head.next;
        int count=1;
        ListNode prev=head;
        temp=head.next;
        while(count!=idx){
            temp=temp.next;
            prev=prev.next;
            count++;
        }
        prev.next=temp.next;
        return head;
    }
}