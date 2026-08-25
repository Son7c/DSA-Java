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
    class Pair implements Comparable<Pair>{
        int val;
        ListNode node;
        public Pair(int v,ListNode n){
            val=v;
            node=n;
        }
        public int compareTo(Pair p2){
            return this.val-p2.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            if (lists[i] != null) {
                pq.add(new Pair(lists[i].val, lists[i]));
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            temp.next=p.node;
            temp=temp.next;
            if(p.node.next!=null){
                pq.add(new Pair(p.node.next.val,p.node.next));
            }
        }
        return dummy.next;
    }
}