package binarytree;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by awang1 on 8/2/15.
 */
public class RightSibling<T> {
    public void assignNext(TreeNodeWithNext<T> root) {
        Queue<TreeNodeWithNext<T>> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        TreeNodeWithNext<T> leftMost = null;
        TreeNodeWithNext<T> prev = null;
        while (!queue.isEmpty()) {
            TreeNodeWithNext<T> current = queue.remove();
            if (current.left != null) {
                if (leftMost == null || current == leftMost.left) {
                    leftMost = current;
                }
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
            if (prev == null) {
                prev = current;
            } else if (current != leftMost) {
                prev.next = current;
            }
        }
    }
}

class TreeNodeWithNext<T> {
    public TreeNodeWithNext<T> left;
    public TreeNodeWithNext<T> right;
    public TreeNodeWithNext<T> next;
    public T data;
}
