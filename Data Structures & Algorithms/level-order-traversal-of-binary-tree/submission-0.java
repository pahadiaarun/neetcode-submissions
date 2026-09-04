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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> level = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        level.offer(root);

        while (!level.isEmpty()) {
            List<TreeNode> levelList = new ArrayList<>();
            List<Integer> levelValList = new ArrayList<>();
            while (!level.isEmpty()) {
                TreeNode p = level.poll();
                levelList.add(p);
                levelValList.add(p.val);
            }
            for (int i = 0; i < levelList.size(); i++) {
                if (levelList.get(i).left != null) {
                    level.offer(levelList.get(i).left);
                }
                if (levelList.get(i).right != null) {
                    level.offer(levelList.get(i).right);
                }
            }
            res.add(levelValList);
        }

        return res;
    }
}
