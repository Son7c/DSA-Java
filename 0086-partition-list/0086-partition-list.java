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
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> small=new ArrayList<>();
        ArrayList<Integer> large=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x) small.add(temp.val);
            else large.add(temp.val);
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<small.size();i++){
            temp.val=small.get(i);
            temp=temp.next;
        }
        for(int i=0;i<large.size();i++){
            temp.val=large.get(i);
            temp=temp.next;
        }
        return head;
    }
}