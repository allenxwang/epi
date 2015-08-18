package binarytree;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

/**
 * Created by awang1 on 8/1/15.
 */
public class Reconstruct<T> {
    public TreeNode<T> reconstruct(List<T> inorder, List<T> preorder) {
        return reconstruct(inorder, preorder, 0, inorder.size(), 0, preorder.size());
    }

    public TreeNode<T> reconstruct(List<T> inorder, List<T> preorder,
                                   int inOrderStartIndex, int inOrderEndIndex,
                                   int preOrderStartIndex, int preOrderEndIndex) {
        if (inOrderStartIndex > inOrderEndIndex) {
            return null;
        }
        TreeNode<T> root = new TreeNode<>();
        root.data = preorder.get(preOrderStartIndex);
        int indexOfRoot = inOrderEndIndex;
        for (int i = inOrderStartIndex; i < inOrderEndIndex; i++) {
            if (inorder.get(i).equals(root.data)) {
                indexOfRoot = i;
                break;
            }
        }
        int sizeOfLeft = indexOfRoot - inOrderStartIndex;
        TreeNode<T> left = reconstruct(inorder, preorder, inOrderStartIndex, indexOfRoot,
                preOrderStartIndex + 1, preOrderStartIndex + 1 + sizeOfLeft);
        TreeNode<T> right = reconstruct(inorder, preorder, indexOfRoot + 1, inOrderEndIndex,
                preOrderStartIndex + 1 + sizeOfLeft, preOrderEndIndex);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode<T> reconstruct(List<T> preOrderWithMarker) {
        Stack<TreeNode<T>> stack = new Stack<>();
        for (int i = preOrderWithMarker.size() - 1; i >= 0; i--) {
            T last = preOrderWithMarker.get(i);
            if (last == null) {
                stack.push(null);
            } else {
                TreeNode<T> node = new TreeNode<>();
                node.data = last;
                TreeNode<T> right = stack.pop();
                TreeNode<T> left = stack.pop();
                node.left = left;
                node.right = right;
                stack.push(node);
            }
        }
        return stack.pop();
    }


}
