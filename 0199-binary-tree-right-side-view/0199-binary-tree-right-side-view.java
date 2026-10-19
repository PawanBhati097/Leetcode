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
		int maximum_depth = -1;

		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> list = new ArrayList<>();
			rightView(root, 0, list);
			return list;
		}

		public void rightView(TreeNode root, int curr_level, List<Integer> list) {
			if(root==null) {
				return;
			}
			if(curr_level>maximum_depth) {
				list.add(root.val);
				maximum_depth=curr_level;
			}
			rightView(root.right,curr_level+1,list);
			rightView(root.left,curr_level+1,list);
		}
	}