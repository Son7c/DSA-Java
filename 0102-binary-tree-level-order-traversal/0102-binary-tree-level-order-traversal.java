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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur==null){
                ans.add(new ArrayList<>(list));
                list.clear();
                if(q.isEmpty()) break;
                q.offer(null);
            }else{
                list.add(cur.val);
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
        }
        return ans;
    }
}