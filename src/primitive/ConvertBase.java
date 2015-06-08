package primitive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by awang1 on 6/8/15.
 */
public class ConvertBase {

    private long getNumber(String number, int b1) {
        long m = 0;
        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';
            long factor = 1;
            for (int j = 0; j < i; j++) {
                factor *= b1;
            }
            m += n * factor;
        }
        return m;
    }

    private String getBase(long n, int b) {
        List<Long> powers = new ArrayList<Long>();
        List<Integer> factors = new ArrayList<Integer>();
        powers.add(1L);
        long p = 1L;
        while (p < n) {
            p = p * b;
            powers.add(p);
        }
        long remaining = n;
        for (int i = powers.size() - 1; i >=0; i--) {
            int factor = (int) (remaining / powers.get(i));
            factors.add(i, factor);
            remaining = n - factor * powers.get(i);
        }
        return
    }

    public String convertTo(String number, int b1, int b2) {

    }
}
