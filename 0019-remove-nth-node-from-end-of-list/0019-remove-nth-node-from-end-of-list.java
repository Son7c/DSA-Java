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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int prev=count-n-1;
        if(prev==-1){
            temp=head;
            ListNode prevv=head;
            temp=temp.next;
            prevv.next=null;
            return temp;
        }
        count=0;
        temp=head;
        while(count!=prev){
            count++;
            temp=temp.next;
        }
        if(count==prev){
            temp.next=temp.next.next;
            return head;
        }
        return head;
    }
}