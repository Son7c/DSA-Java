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
    public ListNode rev(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=rev(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right){
            return head;
        }
        if(left==1){
            ListNode temp=head;
            int count=1;
            while(count<right){
                temp=temp.next;
                count++;
            }
            ListNode next=temp.next;
            temp.next=null;
            ListNode newHead=rev(head);
            head.next=next;
            return newHead;
        }
        ListNode temp1=head;
        ListNode temp2=head;
        int count=1;
        while(count<left-1){
            temp1=temp1.next;
            count++;
        }
        count=1;
        while(count<right){
            temp2=temp2.next;
            count++;
        }
        ListNode secondHalf=temp2.next;
        temp2.next=null;
        ListNode next=temp1.next;
        temp1.next=rev(temp1.next);
        next.next=secondHalf;
        return head;
    }
}