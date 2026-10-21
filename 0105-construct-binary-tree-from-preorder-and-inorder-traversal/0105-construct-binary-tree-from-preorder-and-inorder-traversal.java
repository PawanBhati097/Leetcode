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
		    public TreeNode buildTree(int[] preorder, int[] inorder) {
		       return Create(preorder, 0, preorder.length-1, inorder,0, inorder.length-1);
		    }
		    public TreeNode Create(int[] pre,int plo,int phi, int[] in,int ilo,int ihi) {
		        
		    	if(ilo>ihi ||plo>phi) {
		    		return null;
		    	}
		    	TreeNode node=new TreeNode(pre[plo]);
		    	int idx=Search(in,ilo,ihi,pre[plo]);
		    	int ne=idx-ilo;
		    	node.left= Create(pre,plo+1,plo+ne,in,ilo,idx-1);
		    	node.right= Create(pre,plo+ne+1,phi,in,idx+1,ihi);
		    	
		    	return node;
		    }
		    public int Search(int[] in,int si,int ei,int item) {
		    	for (int i = si; i <=ei; i++) {
					if(in[i]==item) {
						return i;
					}
				}
		    	return -1;
		    }
		}