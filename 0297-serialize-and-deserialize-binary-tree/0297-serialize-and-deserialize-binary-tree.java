/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			reserialize(root, sb);
			return sb.toString();
		}

		public void reserialize(TreeNode root, StringBuilder sb) {
			if (root == null) {
				sb.append(null + ",");
				return;
			}
			sb.append(root.val + ",");
			reserialize(root.left, sb);
			reserialize(root.right, sb);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] arr = data.split(",");
			List<String> l = new ArrayList<>();
			for (String x : arr) {
				l.add(x);
			}
			return redeserialize(l);
		}

		public TreeNode redeserialize(List<String> l) {
			if (l.size() == 0) {
				return null;
			}
			if (l.get(0).equals("null")) {
				l.remove(0);
				return null;
			}
			TreeNode t = new TreeNode(Integer.parseInt(l.get(0)));
			l.remove(0);
			t.left = redeserialize(l);
			t.right = redeserialize(l);
			return t;
		}

	}