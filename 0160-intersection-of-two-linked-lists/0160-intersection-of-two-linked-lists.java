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
        ListNode tempA=headA,tempB=headB;
        while(tempA!=null){
            lenA++;
            tempA=tempA.next;
        }
        while(tempB!=null){
            lenB++;
            tempB=tempB.next;
        }
        int idx=0;
        if(lenA<lenB){
            while(idx!=lenB-lenA){
                idx++;
                headB=headB.next;
            }
        }
        else{
            while(idx!=lenA-lenB){
                idx++;
                headA=headA.next;
            }
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}