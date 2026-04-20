/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp=node.next;
        while(temp!=null){
            if(temp.next==null){
                node.next=null;
            }
            node.val=temp.val;
            temp=temp.next;
            node=node.next;
        }
    }
}