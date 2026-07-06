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
    public void f(TreeNode root,List<Integer> path,List<List<Integer>> res){
        if(root==null) return;
        path.add(root.val);
        if(root.left==null&&root.right==null){
            res.add(new ArrayList<>(path));
        }else{
            f(root.left,path,res);
            f(root.right,path,res);
        }
        path.remove(path.size()-1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        f(root,path,res);
        for(int i=0;i<res.size();i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<res.get(i).size();j++){
                sb.append(res.get(i).get(j));
                sb.append("->");
            }
            sb.delete(sb.length()-2, sb.length());
            ans.add(sb.toString());
        }
        return ans;
    }
}