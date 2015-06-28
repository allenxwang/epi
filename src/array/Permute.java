package array;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang1 on 6/27/15.
 */
public class Permute {
    public <T> List<T> permute(List<T> original, int[] positions) {
        if (positions.length < 1) {
            return original;
        }
        for (int i = 0; i < positions.length; i++) {
            if (leftMostInCycle(positions, i)) {
                int index = i;
                T nextToReplace = original.get(index);
                do {
                    nextToReplace = replace(original, positions[index], nextToReplace);
                    index = positions[index];
                } while (index != i);

            }
        }
        return original;
    }

    private <T> T replace(List<T> original, int index, T newItem) {
        T t = original.get(index);
        original.set(index, newItem);
        return t;
    }

    private <T> List<T> getExpected(List<T> original, int[] positions) {
        List<T> newList = Lists.newArrayListWithCapacity(original.size());
        newList.addAll(original);
        for (int i = 0; i < positions.length; i++) {
            newList.set(positions[i], original.get(i));
        }
        return newList;
    }

    private boolean leftMostInCycle(int[] p, int startIndex) {
        int min = startIndex;
        int next = p[startIndex];
        while (next != startIndex) {
            min = Math.min(min, next);
            next = p[next];
        }
        return startIndex == min;
    }

    @Test
    public void test() {
        List<String> items = Lists.newArrayList("a", "b", "c", "d");
        int[] p = {2, 0, 1, 3};
        assertEquals(getExpected(items, p), permute(items, p));
    }

    @Test
    public void testRandom() {
        List<Character> list = getItems(10);
        int[] p = shuffle(10);
        assertEquals(getExpected(list, p), permute(list, p));
    }

    private List<Character> getItems(int length) {
        List<Character> list = Lists.newArrayList();
        for (int i = 0; i < length; i++) {
            list.add((char) ('a' + i));
        }
        return list;
    }

    private int[] shuffle(int length) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < length; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
