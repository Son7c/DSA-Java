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
    private TreeNode buildTree(int[]postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer, Integer> map){
        if(postStart>postEnd||inStart>inEnd) return null;

        TreeNode root=new TreeNode(postorder[postEnd]);
        int idx=map.get(postorder[postEnd]);
        int rightNums=inEnd-idx;

        root.left=buildTree(postorder,postStart,postEnd-rightNums-1,inorder,inStart,idx-1,map);

        root.right=buildTree(postorder,postEnd-rightNums,postEnd-1,inorder,idx+1,inEnd,map);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }
}