/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       StringBuilder sb=new StringBuilder() ;
helperserialize(root,sb);
 return sb.toString();
    }
    public void helperserialize(TreeNode root,  StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        helperserialize(root.left,sb);
         helperserialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       // if (data.isEmpty()) return null;
        String[]arr=data.split(",");
        Queue<String>q=new LinkedList<>();
        for(String s:arr){
            q.add(s);
        }
     return   helperdeserialize(q);
        
    }
    public TreeNode helperdeserialize( Queue<String>q){
        String val= q.remove();
        if(val.equals("N")){
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(val));
        root.left=helperdeserialize(q);
        root.right=helperdeserialize(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));