package array;

import com.google.common.collect.Lists;
import org.junit.Test;
import utils.ArrayUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang1 on 6/23/15.
 */
public class Increment {
    public List<Integer> increment(int[] array) {
        List<Integer> list = ArrayUtils.getIntList(array);
        int lastResult = array[array.length - 1];
        for (int i = list.size() - 1; i >= 0; i--) {
            lastResult = list.get(i) + 1;
            list.set(i, lastResult % 10);
            if (lastResult != 10) {
                break;
            }
        }
        if (lastResult == 10) {
            list.add(0, 1);
        }
        return list;
    }

    @Test
    public void test() {
        int[] array = {1, 3, 5, 7};
        assertEquals(Lists.newArrayList(1, 3, 5, 8), increment(array));
        int[] a2 = {9, 9, 9, 9, 9, 9};
        assertEquals(Lists.newArrayList(1, 0, 0, 0, 0, 0, 0), increment(a2));
        int[] a3 = {3, 2, 8, 9, 9};
        assertEquals(Lists.newArrayList(3, 2, 9, 0, 0), increment(a3));
    }
}
