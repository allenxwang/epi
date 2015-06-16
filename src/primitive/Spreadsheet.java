package primitive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang on 6/13/15.
 */
public class Spreadsheet {
    public int getNumber(String columnId) {
        int n = 0;
        int factor = 1;
        for (int i = 0; i < columnId.length(); i++) {
            char c = columnId.charAt(columnId.length() - i - 1);
            n += factor * (c - 'A' + 1);
            factor *= 26;
        }
        return n;
    }

    @Test
    public void test() {
        assertEquals(1, getNumber("A"));
        assertEquals(26, getNumber("Z"));
        assertEquals(27, getNumber("AA"));

    }


}
