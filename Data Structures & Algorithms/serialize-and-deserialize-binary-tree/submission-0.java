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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "[]";
        }

        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                res.add("null");
                continue;
            }

            res.add(String.valueOf(node.val));

            queue.offer(node.left);
            queue.offer(node.right);
        }

        // Remove unnecessary nulls from the end
        while (res.get(res.size() - 1).equals("null")) {
            res.remove(res.size() - 1);
        }

        return "[" + String.join(",", res) + "]";
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.equals("[]")) {
            return null;
        }

        // Remove [ and ]
        data = data.substring(1, data.length() - 1);

        String[] values = data.split(",");

        TreeNode root = new TreeNode(
            Integer.parseInt(values[0])
        );

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() && index < values.length) {

            TreeNode node = queue.poll();

            // Left child
            if (!values[index].equals("null")) {

                node.left = new TreeNode(
                    Integer.parseInt(values[index])
                );

                queue.offer(node.left);
            }

            index++;

            // Right child
            if (index < values.length &&
                !values[index].equals("null")) {

                node.right = new TreeNode(
                    Integer.parseInt(values[index])
                );

                queue.offer(node.right);
            }

            index++;
        }

        return root;
    }
}
