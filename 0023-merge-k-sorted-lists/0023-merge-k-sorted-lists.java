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
    public ListNode merge(ListNode tempA,ListNode tempB){
        ListNode res=new ListNode(-1);
        ListNode temp=res;
        while(tempA!=null&&tempB!=null){
            if(tempA.val<=tempB.val){
                temp.next=tempA;
                tempA=tempA.next;
                temp=temp.next;
            }else{
                temp.next=tempB;
                tempB=tempB.next;
                temp=temp.next;
            }
        }
        while(tempA!=null){
            temp.next=tempA;
            tempA=tempA.next;
            temp=temp.next;
        }
        while(tempB!=null){
            temp.next=tempB;
            tempB=tempB.next;
            temp=temp.next;
        }
        return res.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0||(lists.length==1&&lists[0]==null)) return null;
        if(lists.length==1) return lists[0];
        ListNode sorted=null;
        for(int i=0;i<lists.length;i++){
            if(i==0){
                sorted=merge(lists[i],lists[i+1]);
                i=1;
            }else{
                sorted=merge(sorted,lists[i]);
            }
        }
        return sorted;
    }
}