package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang1 on 7/3/15.
 */
public class LookAndSay {
    public String lookAndSay(int length) {
        if (length == 0) {
            return "";
        } else if (length == 1) {
            return "1";
        } else {
            String last = lookAndSay(length - 1);
            StringBuilder sb = new StringBuilder();
            int current = 0;
            int charCount = 1;
            char lastSeen = last.charAt(0);
            while (current < last.length()) {
                current++;
                if (current == last.length() || last.charAt(current) != lastSeen) {
                    sb.append(charCount).append(lastSeen);
                    if (current < last.length()) {
                        lastSeen = last.charAt(current);
                        charCount = 1;
                    }
                } else {
                    charCount++;
                }
            }
            return sb.toString();
        }
    }

    @Test
    public void test() {
        assertEquals("21", lookAndSay(3));
        assertEquals("1211", lookAndSay(4));
        assertEquals("111221", lookAndSay(5));
        assertEquals("1113213211", lookAndSay(8));
    }
}
