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
    public ListNode revLL(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode newHead=revLL(head.next);
        ListNode next=head.next;
        next.next=head;
        head.next=null;
        return newHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next==null) return head;
        ListNode temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        if(length==k){
            return revLL(head);
        }
        ArrayList<ListNode> map=new ArrayList<>();
        int count=1;
        temp=head;
        ListNode start=head;
        ListNode next=null;
        while(temp!=null){
            if(count%k==0){
                System.out.println(start.val);
                map.add(start);
                next=temp.next;
                temp.next=null;
                count++;
                temp=next;
                start=temp;
            }else{
                count++;
                temp=temp.next;
            }
        }
        ArrayList <ListNode> rev=new ArrayList<>();
        for(int i=0;i<map.size();i++){
            rev.add(revLL(map.get(i)));
        }
        for(int i=0;i<map.size()-1;i++){
            map.get(i).next=rev.get(i+1);
        }
        map.get(map.size()-1).next=next;
        return rev.get(0);
    }
}