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
    public ListNode revList(ListNode head){
        if(head==null || head.next ==null){
            return head;
        }
        ListNode newHead=revList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=revList(slow);
        slow=head;
        while(slow!=null && head2!=null){
            if(slow.val!=head2.val) return false;
            slow=slow.next;
            head2=head2.next;
        }
        if(head2!=null && slow==null) return false;
        return true;
    }
}