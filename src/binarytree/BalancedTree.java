package binarytree;

/**
 * Created by awang1 on 7/13/15.
 */
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -2;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int heightLeft = height(root.left);
        if (heightLeft == -2) {
            return -2;
        }
        int heightRight = height(root.right);
        if (heightRight == -2) {
            return -2;
        }
        if (Math.abs(heightLeft - heightRight) > 1) {
            return -2;
        } else {
            return Math.max(heightLeft, heightRight) + 1;
        }
    }
}
