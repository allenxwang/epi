package linkedlist;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by awang1 on 7/5/15.
 */
public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public static <T> ListNode<T> getLinkedList(List<T> list) {
        ListNode<T> first = null;
        ListNode<T> current = null;
        if (list == null) {
            return null;
        }
        for (T node : list) {
            ListNode<T> listNode = new ListNode<>();
            listNode.data = node;
            listNode.next = null;
            if (current != null) {
                current.next = listNode;
            }
            current = listNode;
            if (first == null) {
                first = listNode;
            }
        }
        return first;
    }

    public static <T> List<T> getList(ListNode<T> listNode) {
        List<T> list = Lists.newArrayList();
        ListNode<T> node = listNode;
        while (node != null) {
            list.add(node.data);
            node = node.next;
        }
        return list;
    }

    @Test
    public void testGetLinkedList() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        ListNode<Integer> node = getLinkedList(list);
        int i = 0;
        while (node != null) {
            assertEquals(node.data.intValue(), ++i);
            node = node.next;
        }
        List<Integer> empty = Lists.newArrayList();
        assertNull(getLinkedList(empty));
        ListNode<Integer> one = getLinkedList(Lists.newArrayList(0));
        assertEquals(0, one.data.intValue());
        assertNull(one.next);
    }

    @Test
    public void testGetList() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        ListNode<Integer> node = getLinkedList(list);
        assertEquals(list, getList(node));
        assertEquals(Lists.<Integer>newArrayList(), getList((ListNode<Integer>) null));
    }
}
