package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang1 on 6/22/15.
 */
public class MaxDiff {
    public int maxDiff(int[] array) {
        int smallest = array[0];
        int maxDiff = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            } else if (array[i] - smallest > maxDiff) {
                maxDiff = array[i] - smallest;
            }
        }
        return maxDiff;
    }

    @Test
    public void test() {
        int[] array = {2, 5, 1, 6};
        assertEquals(5, maxDiff(array));
        int[] b = {9, 7, 5, 2, 1};
        assertEquals(0, maxDiff(b));
    }
}
