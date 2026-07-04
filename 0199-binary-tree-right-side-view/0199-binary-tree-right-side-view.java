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
    private void inorder(TreeNode root,int lv, HashMap<Integer, Integer> map) {
        if(root==null) return;
        inorder(root.left,lv+1,map);
        map.put(lv,root.val);
        inorder(root.right,lv+1,map);
    }

    public List<Integer> rightSideView(TreeNode root) {
        int level = 0;
        TreeNode temp = root;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        inorder(root,0, map);
        for(int i:map.keySet()){
            list.add(map.get(i));
        }
        return list;
    }
}