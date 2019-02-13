/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Three Pointer No Extra Memory Solution
        
        // Base Case
        if(head==null || head.next==null) return head;
        
        // Two Nodes
        if(head.next.next==null){
            head.next.next = head;
            head = head.next;
            head.next.next = null;
            return head;
        }

        // More than Three Nodes
        ListNode a = head;
        ListNode b = null;
        ListNode prevNode = null;
        // ListNode prevNode = head.next;
        while(a!=null && a.next!=null){
            
            // Extract B
            b = a.next;
            
            // Swapping
            a.next = b.next;
            b.next = a;
            
            // Checking if First Node
            if(prevNode == null){
                head = b;
                prevNode = b;
            } else {
                prevNode.next = b;
            }
            
            // Updating Pointer
            prevNode = a;
            a = a.next;
        }
        return head;
    }
}
