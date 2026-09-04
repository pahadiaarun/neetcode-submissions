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
    private void inOrderTraversal(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, array);
        array.add(root.val);
        inOrderTraversal(root.right, array);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> array = new ArrayList<>();
        inOrderTraversal(root, array);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) <= array.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
