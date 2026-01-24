/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> map=new HashMap<>();
    public Node cycleUtil(Node node){
        if(node==null) return null;
        Node newNode=new Node(node.val);
        map.put(node,newNode);
        for(Node nei:node.neighbors){
            if(!map.containsKey(nei)){
                newNode.neighbors.add(cycleUtil(nei));
            }else{
                newNode.neighbors.add(map.get(nei));
            }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        return cycleUtil(node);
    }
}