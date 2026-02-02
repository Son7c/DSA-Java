/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hm=new HashMap<>();
        Node temp=head;
        while(temp!=null){
            Node newNode=null;
            if(temp!=null) newNode=new Node(temp.val);
            else newNode=null;
            hm.put(temp,newNode);
            temp=temp.next;
        }
        temp=head;
        Node newHead=new Node(-1);
        Node temp2=newHead;
        while(temp!=null){
            temp2.next=hm.get(temp);
            temp2=temp2.next;
            temp2.random=hm.get(temp.random);
            temp=temp.next;
        }
        return newHead.next;
    }
}