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
    public ListNode mergeNodes(ListNode head) {
        ListNode tempA=head;
        ListNode temp=head.next;
        int sum=0;
        while(temp!=null){
            sum+=temp.val;
            if(temp.val==0){
                tempA.next=new ListNode(sum);
                tempA=tempA.next;
                sum=0;
            }
            temp=temp.next;
        }
        return head.next;
    }
}