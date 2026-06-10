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
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        if(count==1) return null;
        if(n==count) return head.next;
        temp=head;
        int idx=0;
        while(idx!=count-n-1){
            idx++;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}