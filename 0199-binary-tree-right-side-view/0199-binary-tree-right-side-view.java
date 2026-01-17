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
    public int level(TreeNode root,HashMap<Integer,Integer> hm,int lv){
        if(root==null) return 0;
        hm.put(lv,root.val);
        int lh=level(root.left,hm,lv+1);
        int rh=level(root.right,hm,lv+1);
        return 1+Math.max(lh,rh);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        int level=1;
        level=level(root,hm,1);
        for(int i=1;i<=level;i++){
            list.add(hm.get(i));
        }
        return list;
    }
}