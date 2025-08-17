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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        int carry=0,sum=0;
        while(l1!=null&&l2!=null){
            sum=l1.val+l2.val;
            if(sum>9){
                int val=sum+carry;
                temp.next=new ListNode(val%10);
                carry=val/10;
                temp=temp.next;
                l1=l1.next;
                l2=l2.next;
            }else{
                int val=sum+carry;
                temp.next=new ListNode(val%10);
                carry=val/10;
                temp=temp.next;
                l1=l1.next;
                l2=l2.next;
            }
        }
        while(l1!=null){
            int val=l1.val+carry;
            if(val>9){
                temp.next=new ListNode(val%10);
                carry=val/10;
                temp=temp.next;
                l1=l1.next;
            }else{
                temp.next=new ListNode(val);
                carry=0;
                temp=temp.next;
                l1=l1.next;
            }
        }
        while(l2!=null){
            int val=l2.val+carry;
            if(val>9){
                temp.next=new ListNode(val%10);
                carry=val/10;
                temp=temp.next;
                l2=l2.next;
            }else{
                temp.next=new ListNode(val);
                carry=0;
                temp=temp.next;
                l2=l2.next;
            }
        }
        if(carry!=0){
            temp.next=new ListNode(carry);
        }
        return ans.next;
    }
}