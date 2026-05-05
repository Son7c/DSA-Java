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
    public ListNode insertAtHead(ListNode head,ListNode Node){
        ListNode temp=Node;
        while(temp.next!=null) temp=temp.next;
        temp.next=head;
        return Node;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        k=k%length;
        if(k==0) return head;
        temp=head;
        int idx=0;
        while(idx!=length-k-1){
            temp=temp.next;
            idx++;
        }
        ListNode Node=temp.next;
        temp.next=null;
        return insertAtHead(head,Node);
    }
}