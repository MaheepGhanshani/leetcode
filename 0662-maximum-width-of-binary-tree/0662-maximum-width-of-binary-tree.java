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
        TreeNode node;
        long index;
        Pair(TreeNode node,long index ){
            this.node=node;
            this.index=index;
        }
       
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair (root,0));
        long maxWid=0;
        while(!q.isEmpty()){
            int size=q.size();
            long stIdx=q.peek().index;
            long endIdx=q.peek().index;
            maxWid=Math.max(maxWid,endIdx-stIdx+1);
            for(int i=0;i<size;i++){
                Pair curr= q.remove();   
                long idx=curr.index;
                endIdx=idx;
                if(curr.node.left !=null){
                    q.add(new Pair(curr.node.left,idx*2+ 1));
                }
                if(curr.node.right!=null){
                    q.add(new Pair(curr.node.right,idx*2+2));
                }
            }
                maxWid=Math.max(maxWid,(int)(endIdx-stIdx+1));
        }
   return (int)maxWid;
    }
}