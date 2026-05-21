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
    public int maxLevelSum(TreeNode root) {
       List<Integer>sums=new ArrayList<>();
dfs(root,1,sums);
int maxSum=sums.get(0);
int ans =1;
for(int i=1;i<sums.size();i++){
    if(sums.get(i)>maxSum){
        maxSum=sums.get(i);
        ans=i+1;
    
}
}
return ans;
    }
    public void dfs(TreeNode root,int level, List<Integer>sums){
        if(root==null){
            return;
        }
        if(level>sums.size()){
            sums.add(root.val);
        }
        else{
            sums.set(level-1,sums.get(level-1)+root.val);
        }
        dfs(root.left,level+1,sums);
        dfs(root.right,level+1,sums);
    }
  
}