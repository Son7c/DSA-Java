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
    class Info{
        int diam;
        int ht;
        public Info(int d,int h){
            this.diam=d;
            this.ht=h;
        }
    }
    public Info diam(TreeNode root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo=diam(root.left);
        Info rightInfo=diam(root.right);
        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(diam,ht);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Info diam=diam(root);
        return diam.diam-1;
    }
}