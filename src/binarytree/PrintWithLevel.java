package binarytree;

import com.google.common.collect.Maps;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * Created by awang1 on 8/2/15.
 */
public class PrintWithLevel<T> {
    public void printWithLevel(TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode<T> firstNodeAtNextLevel = null;
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            if (node != root && node == firstNodeAtNextLevel) {
                System.out.println();
                firstNodeAtNextLevel = null;
            } else if (node != root){
                System.out.print(" ");
            }
            if (firstNodeAtNextLevel == null) {
                if (node.left != null) {
                    firstNodeAtNextLevel = node.left;
                } else if (node.right != null) {
                    firstNodeAtNextLevel = node.right;
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null){
                queue.offer(node.right);
            }
            System.out.print(node.data);
        }
    }
}
