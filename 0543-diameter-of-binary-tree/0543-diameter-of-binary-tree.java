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
    int max=Integer.MIN_VALUE;
    public int inorder(TreeNode root){
        if(root==null) return 0;
        int left=1+inorder(root.left);
        int right=1+inorder(root.right);
        max=Math.max(max,left+right-1);
        return Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        inorder(root);
        return max-1;
    }
}