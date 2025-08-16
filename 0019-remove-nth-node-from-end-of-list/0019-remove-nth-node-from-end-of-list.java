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
    public static ListNode rev(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode newHead=rev(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null) return null;
        ListNode rev=rev(head);
        if(n==1){
            return rev(rev.next);
        }
        int count=0;
        ListNode temp=rev;
        while(temp.next!=null){
            if(count==n-2){
                break;
            }
            count++;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return rev(rev);
    }
}