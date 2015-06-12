package primitive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang on 6/12/15.
 */
public class Power {
    public double pow(double x, int y) {
        if (x == 0) {
            return 0;
        }
        if (y == 0) {
            return 1;
        } else if (y == 1) {
            return x;
        }
        if (y < 0) {
            return pow(1/x, -y);
        }
        double r = pow(x, y/2);
        if (y % 2 == 0) {
            return r * r;
        } else {
            return r * r * x;
        }
    }

    @Test
    public void test() {
        double delta = 0.00001;
        assertEquals(1, pow(5, 0), delta);
        assertEquals(5.2, pow(5.2, 1), delta);
        assertEquals(1024, pow(2, 10), delta);
        assertEquals(Math.pow(3.2, 5), pow(3.2, 5), delta);
        assertEquals(Math.pow(2, -3), pow(2, -3), delta);
    }
}
