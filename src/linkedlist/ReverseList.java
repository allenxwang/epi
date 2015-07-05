package linkedlist;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang1 on 7/5/15.
 */
public class ReverseList {
    public ListNode<String> reverse(ListNode<String> l) {
        if (l == null) {
            return null;
        } else if (l.next == null) {
            return l;
        }
        ListNode<String> current = l;
        ListNode<String> next = current.next;
        current.next = null;
        ListNode<String> nextnext = null;
        do {
            nextnext = next.next;
            next.next = current;
            current = next;
            next = nextnext;
        } while(next != null);
        return current;
    }

    public ListNode<String> reverse2(ListNode<String> l) {
        if (l == null) {
            return null;
        } else if (l.next == null) {
            return l;
        }
        ListNode<String> current = l;
        ListNode<String> next = current.next;
        current.next = null;
        return recursiveReverse(current, next);
    }

    public ListNode<String> recursiveReverse(ListNode<String> l, ListNode<String> next) {
        if (next == null) {
            return l;
        }
        ListNode<String> nextnext = next.next;
        next.next = l;
        return recursiveReverse(next, nextnext);
    }

    @Test
    public void test() {
        ListNode<String> node = ListNode.getLinkedList(Lists.newArrayList("a", "b", "c", "d"));
        ListNode<String> reversed = reverse2(node);
        assertEquals(Lists.newArrayList("d", "c", "b", "a"), ListNode.getList(reversed));
    }

    @Test
    public void test2() {
        ListNode<String> node = ListNode.getLinkedList(Lists.newArrayList("a"));
        ListNode<String> reversed = reverse2(node);
        assertEquals(Lists.newArrayList("a"), ListNode.getList(reversed));
    }

}
