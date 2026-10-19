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
		    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		    	List<List<Integer>> ans=new ArrayList<>();
		    	List<Integer> list=new ArrayList<>();
		    	HasPathSum(root, targetSum, list, ans);
		    	return ans;
		    }
		    public void HasPathSum(TreeNode root, int targetSum,List<Integer>list,List<List<Integer>> ans) {
		        if(root==null) {
		        	return ;
		        }
		        if(root.left==null && root.right==null) {
		        	if(root.val-targetSum==0) {
		        		list.add(root.val);
		        		ans.add(new ArrayList<Integer>(list));
		        		list.remove(list.size()-1);
		        	}
		        }
		        list.add(root.val);
		        HasPathSum(root.left,targetSum-root.val,list,ans);
		        HasPathSum(root.right,targetSum-root.val,list,ans);
		        list.remove(list.size()-1);
		        
		    }
		}