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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int prefix=0;
        HashMap<Integer,ListNode> map=new HashMap<>();
        map.put(0,dummy);
        while(head!=null){
            prefix+=head.val;
            if(map.containsKey(prefix)){
                ListNode start=map.get(prefix);
                ListNode temp=map.get(prefix).next;
                int p=prefix;
                while(temp!=head){
                    p+=temp.val;
                    map.remove(p);
                    temp=temp.next;
                }
                map.get(prefix).next=head.next;
            }else{
                map.put(prefix,head);
            }
            head=head.next;
        }
        return dummy.next;
    }
}