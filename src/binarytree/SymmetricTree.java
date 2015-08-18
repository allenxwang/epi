package binarytree;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by awang1 on 8/1/15.
 */
public class SymmetricTree<T> {
    public boolean isSymmetric(TreeNode<T> root) {
        if (root == null) {
            return true;
        }
        List<T> left = Lists.newArrayList();
        List<T> right = Lists.newArrayList();
        inOrderLeftFirst(root.left, left);
        inOrderRightFirst(root.right, right);
        return left.equals(right);
    }

    void inOrderLeftFirst(TreeNode<T> root, List<T> list) {
        if (root == null) {
            list.add(null);
        } else {
            inOrderLeftFirst(root.left, list);
            list.add(root.data);
            inOrderLeftFirst(root.right, list);
        }
    }

    void inOrderRightFirst(TreeNode<T> root, List<T> list) {
        if (root == null) {
            list.add(null);
        } else {
            inOrderRightFirst(root.right, list);
            list.add(root.data);
            inOrderRightFirst(root.left, list);
        }
    }
}
