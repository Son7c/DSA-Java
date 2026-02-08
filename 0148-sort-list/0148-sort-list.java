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
    public ListNode sortList(ListNode head) {
        if(head==null) return null;
        ListNode temp=head;
        ArrayList<Integer> list=new ArrayList<>();
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        Integer[]arr=list.toArray(new Integer[list.size()]);
        Arrays.sort(arr);
        temp=new ListNode(-1);
        ListNode newHead=temp;
        for(Integer i:arr){
            temp.next=new ListNode(i);
            temp=temp.next;
        }
        return newHead.next;
    }
}