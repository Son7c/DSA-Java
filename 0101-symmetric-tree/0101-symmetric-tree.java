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
    public boolean f(TreeNode a,TreeNode b){
        if(a==null&&b==null) return true;
        if(a==null||b==null) return false;
        if(a.val!=b.val) return false;
        return f(a.right,b.left)&&f(a.left,b.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null&&root.right==null) return true;
        if(root.left==null||root.right==null) return false;
        return f(root.left,root.right);
    }
}