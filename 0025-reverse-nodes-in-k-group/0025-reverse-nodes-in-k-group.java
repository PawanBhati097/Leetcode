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
		public ListNode reverseKGroup(ListNode head, int k) {
			ListNode dummy = new ListNode();
			ListNode temp = dummy;
			ListNode start = head;
			Stack<ListNode> st = new Stack<>();
			while (head != null || st.size() == k) {
				if (st.size() == k) {
					start = head;
					while (!st.isEmpty()) {
						dummy.next = st.pop();
						dummy = dummy.next;
					}
					dummy.next = null;
				} else {
					st.push(head);
					head = head.next;
				}
			}

			if (!st.isEmpty()) {
				dummy.next = start;
			}
			return temp.next;
		}
	}