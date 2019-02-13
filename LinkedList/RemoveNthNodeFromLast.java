/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Empty case
        if(head==null || (head.next==null && n==1)) return null;
        
        // One pass solution
        ListNode nextPtr = head;
        ListNode currPtr = head;
        
        // Displacing Ptr by nth
        int countPtr = 0;
        while(countPtr!=n) {
            nextPtr = nextPtr.next;
            countPtr += 1;
        }
        
        // Empty Last then Update Head
        if(countPtr==n && nextPtr==null){
            head = head.next;
            return head;
        }
        
        // iterating till next ptr reaches last
        while(nextPtr.next!=null) {
            nextPtr = nextPtr.next;
            currPtr = currPtr.next;
            countPtr += 1;
        }
        
        // Updating Result
        currPtr.next = currPtr.next.next;
        
        return head;
    }
}
