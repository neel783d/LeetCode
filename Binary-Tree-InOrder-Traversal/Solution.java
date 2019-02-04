/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> st =  new Stack<>();
        
        if(root!=null){
            parent.put(root, null);
            st.push(root);
        }
        
        while(!st.empty()) {
        
            // Pop
            TreeNode currNode = st.pop();
            TreeNode parentNode = parent.get(currNode);
            
            // Left not visited
            if(currNode.left!=null && !parent.containsKey(currNode.left)){
                parent.put(currNode.left, currNode);
                
                // Adding it into stack
                st.push(currNode);
                st.push(currNode.left);
            }    
            // Right not visited then adding current node to result and right node to stack
            else if(currNode.right!=null && !parent.containsKey(currNode.right)){
                parent.put(currNode.right, currNode);
                
                // Adding it into stack
                st.push(currNode.right);
                result.add(currNode.val);
            }
            
            // no child case
            else {
                result.add(currNode.val);
            }
        }
        return result;
    }
}
