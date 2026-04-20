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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode headB=revLL(slow.next);
        slow.next=null;
        int max=0;
        while(head!=null){
            int sum=head.val+headB.val;
            max=Math.max(max,sum);
            head=head.next;
            headB=headB.next;
        }
        return max;
    }
}