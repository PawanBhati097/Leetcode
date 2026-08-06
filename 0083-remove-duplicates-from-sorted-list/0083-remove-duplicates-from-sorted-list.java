/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        
        // Traverse the list
        while (current != null && current.next != null) {
            // If current and next have same value
            if (current.val == current.next.val) {
                // Skip the next node (remove duplicate)
                current.next = current.next.next;
            } else {
                // Move to next node
                current = current.next;
            }
        }
        
        return head;
    }
}