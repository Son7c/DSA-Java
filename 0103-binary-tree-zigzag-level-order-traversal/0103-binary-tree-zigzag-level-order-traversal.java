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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        q.addLast(null);
        int v = 1;
        while (!q.isEmpty()) {
            TreeNode n = null;
            if (v == -1)
                n = q.pollLast();
            else
                n = q.pollFirst();
            if (n == null) {
                ans.add(new ArrayList<>(list));
                list.clear();
                if (q.isEmpty())
                    break;
                if (v == 1)
                    q.addFirst(null);
                else
                    q.addLast(null);
                v = v == 1 ? -1 : 1;
            } else {
                list.add(n.val);
                if (v == 1) {
                    if (n.left != null)
                        q.addLast(n.left);
                    if (n.right != null)
                        q.addLast(n.right);
                } else {
                    if (n.right != null)
                        q.addFirst(n.right);
                    if (n.left != null)
                        q.addFirst(n.left);
                }
            }
        }
        return ans;
    }
}