package utils;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * Created by awang1 on 6/21/15.
 */
public class ArrayUtils {
    private static final Random random = new Random();

    public static int[] getRandom(int length, int max) {
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = random.nextInt(max);
        }
        return a;
    }

    public static List<Integer> getIntList(int[] array) {
        List<Integer> list = Lists.newArrayList();
        for (int i: array) {
            list.add(i);
        }
        return list;
    }
}
