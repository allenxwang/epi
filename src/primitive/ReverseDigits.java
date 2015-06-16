package primitive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang on 6/13/15.
 */
public class ReverseDigits {
    public String getStringNoSign(int n) {
        int m = n >= 0 ? n : -n;
        StringBuilder sb = new StringBuilder();
        while (m > 0) {
            int d = m % 10;
            sb.append(d);
            m = m / 10;
        }
        if (m == 0 && sb.length() == 0) {
            sb.append(0);
        }
        return sb.toString();
    }

    public int reverseDigits(int n) {
        String s = getStringNoSign(n);
        int m = 0;
        int factor = 1;
        for (int i = 0; i < s.length(); i++) {
            m +=  factor * (s.charAt(s.length() - 1 - i) - '0');
            factor *= 10;
        }
        return n >= 0 ? m : -m;
    }

    public int reverseDigits2(int n) {
        int m = (n >= 0) ? n : -n;
        int r = 0;
        while (m > 0) {
            r = r * 10 + m % 10;
            m = m / 10;
        }
        return (n >= 0) ? r : -r;

    }

    @Test
    public void test() {
        assertEquals(24, reverseDigits2(42));
        assertEquals(-314, reverseDigits2(-413));
    }
}
