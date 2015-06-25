package array;

/**
 * Created by awang1 on 6/24/15.
 */
public class SpiralPrint {
    public void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            printCircle(a, i);
        }

    }

    public void printCircle(int[][] a, int n) {
        for (int y = n; y < a.length - n; y++) {
            print(a[n][y]);
        }
        for (int x = n + 1; x < a.length - n - 1; x++) {
            print(a[x][a.length - n - 1]);
        }
        for (int y = a.length - n - 1; y >= n; y--) {
            print(a[a.length - n - 1][y]);
        }
        for (int x = a.length - n - 2; x >= n + 1; x--) {
            print(a[x][n]);
        }
    }

    public void print(int i) {
        System.out.println(i);
    }
}
