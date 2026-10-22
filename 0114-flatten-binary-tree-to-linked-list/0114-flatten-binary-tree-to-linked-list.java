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
		    public void flatten(TreeNode root) {
		        MakeLL(root);
		    }
		    public TreeNode MakeLL(TreeNode root) {
		    	if(root==null) {
		    		return null;
		    	}
		    	if(root.left==null && root.right==null) {
		    		return root;
		    	}
		    	TreeNode lefttail=MakeLL(root.left);
		    	TreeNode righttail=MakeLL(root.right);
		    	if(lefttail!=null) {
		    		lefttail.right=root.right;
		    		root.right=root.left;
		    		root.left=null;
		    	}
		    	return righttail!=null ?righttail:lefttail;
		    }
		}