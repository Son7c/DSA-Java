class ListNode{
    String val;
    ListNode next;
    ListNode prev;

    public ListNode(String v){
        this.val=v;
        this.next=null;
        this.prev=null;
    }
}
class BrowserHistory {
    ListNode head;
    ListNode temp;
    public BrowserHistory(String homepage) {
        head=new ListNode(homepage);
        temp=head;
    }
    
    public void visit(String url) {
        if(temp.next!=null){
            ListNode next=temp.next;
            next.prev=null;
            temp.next=new ListNode(url);
            temp.next.prev=temp;
            temp=temp.next;
            return;
        }
        temp.next=new ListNode(url);
        temp.next.prev=temp;
        temp=temp.next;
    }
    
    public String back(int steps) {
        int count=0;
        while(temp.prev!=null&&count!=steps){
            temp=temp.prev;
            count++;
        }
        return temp.val;
    }
    
    public String forward(int steps) {
        int count=0;
        while(temp.next!=null&&count!=steps){
            temp=temp.next;
            count++;
        }
        return temp.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */