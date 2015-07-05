package linkedlist;

import array.Increment;
import com.google.common.collect.Lists;
import org.junit.Test;
import utils.ArrayUtils;

import java.lang.reflect.Array;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang1 on 7/5/15.
 */
public class MergeSortedList {
    public ListNode<Integer> merge(ListNode<Integer> l, ListNode<Integer> m) {
        ListNode<Integer> f = null;
        ListNode<Integer> first = null;
        ListNode<Integer> smaller = null;
        while (l != null && m != null) {
            if (l.data < m.data) {
                smaller = l;
                l = l.next;
            } else {
                smaller = m;
                m = m.next;
            }
            if (f != null) {
                f.next = smaller;
                f = smaller;
            } else {
                first = smaller;
                f = smaller;
            }
        }
        if (l != null) {
            smaller = l;
        } else if (m != null) {
            smaller = m;
        }
        if (f != null) {
            f.next = smaller;
        } else {
            first = smaller;
        }
        return first;
    }

    @Test
    public void test() {
        ListNode<Integer> l = ListNode.getLinkedList(ArrayUtils.getIntList(new int[]{2, 5, 7}));
        ListNode<Integer> m = ListNode.getLinkedList(ArrayUtils.getIntList(new int[]{3, 11}));
        ListNode<Integer> merged = merge(l, m);
        assertEquals(ArrayUtils.getIntList(new int[]{2, 3, 5, 7, 11}), ListNode.getList(merged));
    }

    @Test
    public void test2() {
        ListNode<Integer> l = ListNode.getLinkedList(ArrayUtils.getIntList(new int[]{2, 5, 7}));
        ListNode<Integer> m = ListNode.getLinkedList(ArrayUtils.getIntList(new int[]{5, 11}));
        ListNode<Integer> merged = merge(l, m);
        System.out.println(ListNode.getList(merged));
        assertEquals(ArrayUtils.getIntList(new int[]{2, 5, 5, 7, 11}), ListNode.getList(merged));
    }

    @Test
    public void test3() {
        ListNode<Integer> l = ListNode.getLinkedList(ArrayUtils.getIntList(new int[]{2, 5, 7}));
        ListNode<Integer> m = null;
        ListNode<Integer> merged = merge(l, m);
        System.out.println(ListNode.getList(merged));
        assertEquals(ArrayUtils.getIntList(new int[]{2, 5, 7}), ListNode.getList(merged));
    }

}
