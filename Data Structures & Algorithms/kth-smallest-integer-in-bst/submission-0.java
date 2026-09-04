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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> array = new ArrayList<>();
        inOrderTraversal(root, array);
        return array.get(k-1);
        
    }
}
