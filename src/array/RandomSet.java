package array;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;
import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created by awang1 on 6/28/15.
 */
public class RandomSet {
    public int[] randomSet(int n, int k) {
        Map<Integer, Integer> changed = Maps.newHashMap();
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int chosenIndex = random.nextInt(n - i);
            swap(chosenIndex, n - 1 - i, changed);
        }
        return getSelected(changed, n, k);
    }

    private int getValueForKey(int i, Map<Integer, Integer> changed) {
        if (changed.containsKey(i)) {
            return changed.get(i);
        } else {
            return i;
        }
    }

    private void setValue(int index, int value, Map<Integer, Integer> changed) {
        if (index == value) {
            changed.remove(index);
        } else {
            changed.put(index, value);
        }
    }

    private void swap(int i, int j, Map<Integer, Integer> changed) {
        int vi = getValueForKey(i, changed);
        int vj = getValueForKey(j, changed);
        setValue(i, vj, changed);
        setValue(j, vi, changed);
    }

    private int[] getSelected(Map<Integer, Integer> changed, int n, int k) {
        int[] result = new int[k];
        int count = 0;
        for (int i = n - k; i < n; i++) {
            result[count++] = getValueForKey(i, changed);
        }
        return result;
    }

    @Test
    public void test() {
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            Set<Integer> set = Sets.newHashSet(ArrayUtils.getIntList(randomSet(5, 4)));
            if (set.contains(0)) {
                count++;
            }
        }
        System.out.println(count);
    }

}
