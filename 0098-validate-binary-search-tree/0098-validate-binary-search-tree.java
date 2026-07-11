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
    private boolean check(TreeNode root,long left,long right){
        if(root==null) return true;
        if((long)root.val>=right||(long)root.val<=left) return false;
        boolean l=check(root.left,left,(long)root.val);
        boolean r=check(root.right,(long)root.val,right);
        return l&&r;
    }
    public boolean isValidBST(TreeNode root) {
        if(root.left==null&&root.right==null) return true;
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}