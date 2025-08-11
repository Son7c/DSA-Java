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
    class Pair{
        int ht;
        boolean bal;
        public Pair(int h,boolean b){
            this.ht=h;
            this.bal=b;
        }
    }
    public Pair balanced(TreeNode root){
        if(root==null){
            return new Pair(0,true);
        }
        Pair left=balanced(root.left);
        Pair right=balanced(root.right);
        boolean isBal=left.bal&&right.bal&&Math.abs(left.ht-right.ht)<=1;
        int height=Math.max(left.ht,right.ht)+1;
        
        return new Pair(height,isBal);

    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return balanced(root).bal;
    }
}