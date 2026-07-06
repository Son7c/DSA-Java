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
    public void f(TreeNode root,String path,List<String> ans){
        if(root.left==null&&root.right==null){
            ans.add(path);
        }
        if(root.left!=null) f(root.left,path+"->"+root.left.val,ans);
        if(root.right!=null) f(root.right,path+"->"+root.right.val,ans);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        f(root,root.val+"",ans);
        return ans;
    }
}