package array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by awang1 on 6/27/15.
 */
public class WinningGame {
    public boolean canWin(int[] a) {
        int maxReachable = 0;
        for (int i = 0; i < a.length; i++) {
            maxReachable = Math.max(maxReachable, i + a[i]);
            if (maxReachable <= i) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(canWin(new int[]{3, 3, 1, 0, 2, 0, 1}));
        assertFalse(canWin(new int[]{3, 2, 0, 0, 2, 0, 1}));
    }
}
