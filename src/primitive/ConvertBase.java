package primitive;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang1 on 6/8/15.
 */
public class ConvertBase {

    private long getNumber(String number, int b1) {
        long m = 0;
        long factor = 1;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(number.length() - i - 1);
            int n;
            if (Character.isDigit(c)) {
                n = c - '0';
            } else {
                n = 10 + (c - 'A');
            }
            m += n * factor;
            factor *= b1;
        }
        return m;
    }

    private String getBase(long n, int b) {
        List<Long> powers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        powers.add(1L);
        long p = 1L;
        while (p < n) {
            p = p * b;
            powers.add(p);
        }
        long remaining = n;
        for (int i = powers.size() - 1; i >= 0; i--) {
            int factor = (int) (remaining / powers.get(i));
            if (sb.length() == 0 && factor == 0) {
                continue;
            }
            if (factor >= 10) {
                sb.append((char) ('A' + (factor - 10)));
            } else {
                sb.append(factor);
            }
            remaining -= factor * powers.get(i);
        }
        return sb.toString();
    }

    public String convertTo(String number, int b1, int b2) {
        long n = getNumber(number, b1);
        return getBase(n, b2);
    }

    @Test
    public void test() {
        String x = "1011";
        assertEquals(11, getNumber(x, 2));
        assertEquals("11", convertTo(x, 2, 10));
        assertEquals(11, getNumber("11", 10));
        assertEquals("1011", convertTo("11", 10, 2));
        assertEquals("F", convertTo("15", 10, 16));
        assertEquals("255", convertTo("FF", 16, 10));
        assertEquals("11111111", convertTo("FF", 16, 2));
    }
}
