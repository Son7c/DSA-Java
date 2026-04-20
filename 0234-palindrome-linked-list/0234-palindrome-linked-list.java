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
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode revHead=revLL(slow.next);
        slow.next=null;
        slow=head;
        fast=revHead;
        while(slow!=null&&fast!=null){
            if(slow.val!=fast.val) return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
}