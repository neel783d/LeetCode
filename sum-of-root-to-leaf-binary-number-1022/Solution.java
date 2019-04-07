/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    long result = 0;
    
    public void allPath(TreeNode root, long curr) {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            result = (result + (curr << 1) % 1000000007 + root.val) % (1000000007);
            return;
        }
        else {
            allPath(root.left, (curr << 1) % 1000000007 + root.val);
            allPath(root.right, (curr << 1) % 1000000007 + root.val);  
        } 
    }
    
    public int sumRootToLeaf(TreeNode root) {
        allPath(root, 0);
        // tem.out.println((root.val << 1) + 1L);
        return (int) result;
    }
}
