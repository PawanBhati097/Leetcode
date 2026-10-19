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
		    public boolean isBalanced(TreeNode root) { //|lh-rh|<=1 
		        return is_Balanced(root).isBal;
		    }
		    public BalancedPair is_Balanced(TreeNode root) {
		    	if(root==null) {
		    		return new BalancedPair();
		    	}
		    	BalancedPair lbp=is_Balanced(root.left);
		    	BalancedPair rbp=is_Balanced(root.right);
		    	BalancedPair sbp=new BalancedPair();
		    	sbp.ht=Math.max(lbp.ht,rbp.ht)+1;
		    	sbp.isBal=lbp.isBal && rbp.isBal && Math.abs(lbp.ht-rbp.ht)<=1;
		    	return sbp;
		    	
		    }
		    class BalancedPair{
		    	boolean isBal=true;
		    	int ht=-1;
		    }
		}