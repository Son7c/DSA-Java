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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res=new ListNode(-1);
        ListNode temp=res;
        ListNode tempA=list1;
        ListNode tempB=list2;
        while(tempA!=null&&tempB!=null){
            if(tempA.val<=tempB.val){
                temp.next=tempA;
                temp=temp.next;
                tempA=tempA.next;
            }else{
                temp.next=tempB;
                temp=temp.next;
                tempB=tempB.next;
            }
        }
        while(tempA!=null){
            temp.next=tempA;
            temp=temp.next;
            tempA=tempA.next;
        }
        while(tempB!=null){
            temp.next=tempB;
            temp=temp.next;
            tempB=tempB.next;
        }
        return res.next;
    }
}