package stack;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by awang1 on 8/9/15.
 */
public class RPN {
    public int evaluate(String expr) {
        return evaluate(new Stack<String>(), expr);
    }

    int evaluate(Stack<String> s, String expr) {
        if (expr.length() == 0)  {
            return Integer.parseInt(s.pop());
        } else {
            if (expr.startsWith("-") && (expr.length() > 1 && expr.charAt(1) != ',')) {
                s.push("-");
                return evaluate(s, expr.substring(1));
            }
            String head;
            String tail;
            int delimiterIndex = expr.indexOf(',');
            if (delimiterIndex < 0) {
                head = expr;
                tail = "";
            } else {
                head = expr.substring(0, delimiterIndex);
                tail = expr.substring(delimiterIndex + 1);
            }
            if (((head.equals("+") || head.equals("x") || head.equals("/")) || head.equals("-"))) {
                int y = Integer.parseInt(s.pop());
                int x = Integer.parseInt(s.pop());
                int result;
                if (head.equals("+")) {
                    result = x + y;
                } else if (head.equals("-")) {
                    result = x - y;
                } else if (head.equals("x")) {
                    result = x * y;
                } else {
                    result = x / y;
                }
                s.push(String.valueOf(result));
                return evaluate(s, tail);
            } else {
                int op = Integer.parseInt(head);
                while (!s.empty() && s.peek().equals("-")) {
                    s.pop();
                    op = 0 - op;
                }
                s.push(String.valueOf(op));
                return evaluate(s, tail);
            }
        }
    }

    @Test
    public void test() {
        String expr1 = "2,5,+";
        assertEquals(7, evaluate(expr1));
        String expr0 = "5,3,-";
        assertEquals(2, evaluate(expr0));
        String expr2 = "10,3,5,+,-";
        assertEquals(2, evaluate(expr2));
        String expr3 = "10,5,3,-,x";
        assertEquals(20, evaluate(expr3));
    }

    @Test
    public void test2() {
        String expr = "-----2";
        assertEquals(-2, evaluate(expr));
        String expr2 = "-2,3,+";
        assertEquals(1, evaluate(expr2));
    }

    @Test
    public void test3() {
        String expr = "3,4,+,2,1,x,+";
        assertEquals(9, evaluate(expr));
    }


}
