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
    public TreeNode buildTree(int[] nums,int left,int right,HashMap<Integer,TreeNode> map){
        if(left>right) return null;
        int mid=left+((right-left)/2);
        TreeNode root=map.get(nums[mid]);
        root.left=buildTree(nums,left,mid-1,map);
        root.right=buildTree(nums,mid+1,right,map);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        HashMap<Integer,TreeNode> map=new HashMap<>();
        for(int i:nums){
            map.put(i,new TreeNode(i));
        }
        return buildTree(nums,0,nums.length-1,map);
    }
}