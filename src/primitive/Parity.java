package primitive;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by awang1 on 6/7/15.
 */
public class Parity {

    private Map<Short, Integer> parityMap = new HashMap<>();
    private static final long MASK = 1 << 16 - 1;

    public  int computeParity(long[] input) {
        int parity = 0;
        for (long n: input) {
            for (int i = 0; i < 3; i++) {
                short x = (short) ((n >>> (16 * i)) & MASK);
                parity += computeParity(x);
            }
        }
        return parity % 2;
    }

    private int computeParity(short n) {
        Integer p = parityMap.get(n);
        if (p != null) {
            return p;
        }
        int count = 0;
        for (int i = 0; i < 16; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        p = count % 2;
        parityMap.put(n, p);
        return p;
    }

    @Test
    public void test() {
        assertTrue(true);
    }

}
