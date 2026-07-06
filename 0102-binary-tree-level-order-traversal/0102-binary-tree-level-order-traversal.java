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

 class Pair{
    int r;
    TreeNode node;
    public Pair(int x,TreeNode n){
        this.node=n;
        this.r=x;
    }
 }
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        TreeMap<Integer,List<Integer>> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        q.offer(new Pair(0,root));
        while(!q.isEmpty()){
            Pair p=q.poll();
            TreeNode n=p.node;
            int row=p.r;
            if(map.containsKey(row)){
                map.get(row).add(n.val);
            }else{
                map.put(row, new ArrayList<>(Arrays.asList(n.val)));   
            }
            if(n.left!=null) q.offer(new Pair(row+1,n.left));
            if(n.right!=null) q.offer(new Pair(row+1,n.right));
        }
        for(int i:map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }
}