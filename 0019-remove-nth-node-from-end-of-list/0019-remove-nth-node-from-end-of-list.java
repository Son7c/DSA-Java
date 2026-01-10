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
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        if(length==n){
            return head.next;
        }
        int idx=length-n-1;
        length=0;
        temp=head;
        while(length!=idx){
            temp=temp.next;
            length++;
        }
        temp.next=temp.next.next;
        return head;
    }
}