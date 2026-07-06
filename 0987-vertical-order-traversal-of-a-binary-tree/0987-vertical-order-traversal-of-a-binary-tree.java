/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Tuple{
    TreeNode node;
    int x,y;
    public Tuple(TreeNode _node,int _x,int _y){
        this.node=_node;
        this.x=_x;
        this.y=_y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.poll();
            TreeNode n=t.node;
            int x=t.x;
            int y=t.y;
            if(map.containsKey(x)){
                if(map.get(x).containsKey(y)){
                    map.get(x).get(y).add(n.val);
                }else{
                    PriorityQueue<Integer> temp=new PriorityQueue<>();
                    temp.add(n.val);
                    map.get(x).put(y,temp);
                }
            }else{
                map.put(x,new TreeMap<>());
                map.get(x).put(y,new PriorityQueue<>());
                map.get(x).get(y).add(n.val);
            }
            if(n.left!=null) q.offer(new Tuple(n.left,x-1,y+1));
            if(n.right!=null) q.offer(new Tuple(n.right,x+1,y+1));
        }
        for(int i:map.keySet()){
            List<Integer> list=new ArrayList<>();
            for(int j:map.get(i).keySet()){
                PriorityQueue<Integer> pq=map.get(i).get(j);
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }
}