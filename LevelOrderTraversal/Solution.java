/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Defining Result
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // Defining Queue
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        Queue<Integer> height = new LinkedList<Integer>();
        
        // Root Cases
        if (root != null){
            // Adding Root to the Result    
            result.add(Arrays.asList(root.val));
            
            // Appending Root to Queue
            que.add(root);
            height.add(0);
        }
        
        //Store All Same Height nodes
        List<Integer> sib = new ArrayList();
        int sibHeight = -1;
        
        // BFS Exploration
        while (!que.isEmpty()) {
            
            // Deque Elements
            TreeNode node = que.remove();
            int currHeight = height.remove();
            
            // Checking if Height is same as sibling height
            if (sibHeight != currHeight) {
                if (!sib.isEmpty()){
                    result.add(sib);    
                }
                sib = new ArrayList<Integer>();
                sibHeight = currHeight;
            }
            
            // Adding Sibling Nodes to the Queue
            if (node.left != null) {
                sib.add(node.left.val);
                que.add(node.left);
                height.add(currHeight+1);
            }
            if (node.right != null) {
                sib.add(node.right.val); 
                que.add(node.right);
                height.add(currHeight+1);
            }
        }
        
        // Adding Children to the Result
        if (!sib.isEmpty()) {
            result.add(sib);    
        }
        
        // Bottom Up List by result reversal
        Collections.reverse(result);
        
        return result;
    }
}
