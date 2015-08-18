package stack;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang1 on 8/18/15.
 */
public class MaxStack<T extends Comparable<T>> extends Stack<T> {
    private final Stack<Map.Entry<T, Integer>> max;

    public MaxStack() {
        super();
        max = new Stack<>();
    }

    @Override
    public T push(T item) {
        if (max.isEmpty()) {
            max.push(new AbstractMap.SimpleEntry<>(item, 1));
        } else {
            T currentMax = max.peek().getKey();
            if (item.compareTo(currentMax) > 0) {
                max.push(new AbstractMap.SimpleEntry<>(item, 1));
            } else if (item.compareTo(currentMax) == 0) {
                max.peek().setValue(max.peek().getValue() + 1);
            }
        }
        return super.push(item);
    }

    @Override
    public synchronized T pop() {
        T item = super.pop();
        T currentMax = max.peek().getKey();
        if (item.compareTo(currentMax) == 0) {
            int newCount = max.peek().getValue() - 1;
            if (newCount == 0) {
                max.pop();
            } else {
                max.peek().setValue(newCount);
            }
        }
        return item;
    }

    public T max() {
        if (max.isEmpty()) {
            throw new IllegalStateException("No item in stack yet");
        } else {
            return max.peek().getKey();
        }
    }

    @Test
    public void test() {
        MaxStack<Integer> stack = new MaxStack<>();
        stack.push(5); // 5
        assertEquals(5, stack.max().intValue());
        stack.push(4); // 5, 4
        assertEquals(5, stack.max().intValue());
        stack.push(9); // 5, 4, 9
        assertEquals(9, stack.max().intValue());
        stack.push(7); // 5, 4, 9, 7
        assertEquals(9, stack.max().intValue());
        stack.push(9); // 5, 4, 9, 7, 9,
        stack.push(0); // 5, 4, 9, 7, 9, 0
        stack.pop();   // 5, 4, 9, 7, 9
        stack.pop();   // 5, 4, 9, 7
        assertEquals(9, stack.max().intValue());
        stack.pop();
        stack.pop();
        assertEquals(5, stack.max().intValue());
    }
}
