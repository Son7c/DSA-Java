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
        int carry=0;
        ListNode head=new ListNode((l1.val+l2.val)%10);
        ListNode temp=head;
        carry=(l1.val+l2.val)/10;
        l1=l1.next;
        l2=l2.next;
        while(l1!=null&&l2!=null){
            int sum=l1.val+l2.val+carry;
            if(sum>9){
                carry=sum/10;
                temp.next=new ListNode(sum%10);
                temp=temp.next;
                l1=l1.next;
                l2=l2.next;
            }
            else{
                temp.next=new ListNode(sum);
                temp=temp.next;
                l1=l1.next;
                l2=l2.next;
                carry=0;
            }
        }
        while(l1!=null){
            int sum=l1.val+carry;
            if(sum>9){
                temp.next=new ListNode(sum%10);
                temp=temp.next;
                l1=l1.next;
            }else{
                temp.next=new ListNode(sum);
                temp=temp.next;
                l1=l1.next;
                carry=0;
            }
        }
        while(l2!=null){
            int sum=l2.val+carry;
            if(sum>9){
                temp.next=new ListNode(sum%10);
                temp=temp.next;
                l2=l2.next;
            }else{
                temp.next=new ListNode(sum);
                temp=temp.next;
                l2=l2.next;
                carry=0;
            }
        }
        if(carry>0){
            temp.next=new ListNode(carry);
            temp=temp.next;
        }
        return head;
    }
}