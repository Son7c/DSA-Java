/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0,lenB=0;
        ListNode temp=headA;
        while(temp!=null){
            lenA++;
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            lenB++;
            temp=temp.next;
        }
        int diff=Math.abs(lenA-lenB);
        temp=lenA>lenB?headA:headB;
        while(diff!=0){
            temp=temp.next;
            diff--;
        }
        ListNode temp2=lenA>lenB?headB:headA;
        while(temp!=temp2){
            temp=temp.next;
            temp2=temp2.next;
        }
        return temp;
    }
}