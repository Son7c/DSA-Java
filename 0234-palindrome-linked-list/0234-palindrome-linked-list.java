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
    public ListNode revLL(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode newHead=revLL(head.next);
        ListNode next=head.next;
        next.next=head;
        head.next=null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        ListNode slow=head,fast=head.next,temp=null;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        temp=revLL(slow.next);
        slow.next=null;
        while(head!=null&&temp!=null){
            if(head.val!=temp.val) return false;
            head=head.next;
            temp=temp.next;
        }
        return true;
    }
}