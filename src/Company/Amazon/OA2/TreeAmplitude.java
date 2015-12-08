/*
 * Given a tree of N nodes, return the amplitude of the tree
 */
package Company.Amazon.OA2;

/**
 *
 * @author Wu
 */
public class TreeAmplitude {

    public class TreeNode {

        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public int treeAmplitude(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, root.value, root.value);
    }

    private int helper(TreeNode node, int min, int max) {
        if (node == null) {
            return max - min;
        }

        if (node.value < min) {
            min = node.value;
        }
        if (node.value > max) {
            max = node.value;
        }

        return Math.max(helper(node.left, min, max), helper(node.right, min, max));
    }
}
