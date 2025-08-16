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
    public ListNode mid(ListNode head){
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode newHead=reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    public void reorderList(ListNode head) {
        ListNode mid=mid(head);
        ListNode rev=reverse(mid.next);
        mid.next=null;
        ListNode temp=head;
        ListNode nextTemp=null;
        ListNode nextRev=null;
        while(rev!=null){
            nextTemp=temp.next;
            nextRev=rev.next;
            temp.next=rev;
            rev.next=nextTemp;
            temp=nextTemp;
            rev=nextRev;
        }
    }
}