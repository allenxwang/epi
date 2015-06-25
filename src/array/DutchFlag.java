package array;

import com.google.common.collect.Lists;
import org.junit.Test;
import utils.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang1 on 6/20/15.
 */
public class DutchFlag {
    public void rearrange(int[] input, int index) {
        swap(input, index, 0);
        int lt = 0;
        int gt = input.length - 1;
        int i = 1;
        int pivot = input[0];
        while (i <= gt) {
            if (input[i] < pivot) {
                swap(input, lt, i);
                lt++;
            } else if (input[i] > pivot) {
                swap(input, i, gt);
                gt--;
            } else {
                i++;
            }
        }

    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // @Test
    public void test() {
        int[] array = {3, 5, 7, 5, 2};
        rearrange(array, 1);
        List<Integer> result = Lists.newArrayList();
        for (int i: array) {
            result.add(i);
        }
        List<Integer> expected = Lists.newArrayList(3, 2, 5, 5, 7);
        assertEquals(expected, result);
    }

    @Test
    public void testRandom() {

        int[] array = ArrayUtils.getRandom(10, 5);
        int index = new Random().nextInt(10);
        System.out.println(ArrayUtils.getIntList(array));
        System.out.println("Pivot is " + array[index]);
        rearrange(array, index);
        System.out.println(ArrayUtils.getIntList(array));
    }
}
