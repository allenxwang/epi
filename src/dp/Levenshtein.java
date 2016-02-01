package dp;

import org.junit.Test;

/**
 * Created by awang on 1/31/16.
 */
public class Levenshtein {
    public int getDistance(String x, String y) {
        int lengthX = x.length();
        int lengthY = y.length();
        int[][] distance = new int[lengthX][lengthY];
        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                int minDistance;
                if (x.charAt(i) == y.charAt(j)) {
                    minDistance = getDistance(i - 1, j - 1, distance);
                } else {
                    int distance1 = getDistance(i - 1, j - 1, distance);
                    int distance2 = getDistance(i, j - 1, distance);
                    int distance3 = getDistance(i - 1, j, distance);
                    minDistance = Math.min(Math.min(distance1, distance2), distance3) + 1;
                }
                distance[i][j] = minDistance;
            }
        }
        return getDistance(lengthX - 1, lengthY - 1, distance);
    }

    public int getDistance(int x, int y, int[][] distance) {
        if (x < 0) {
            return y + 1;
        } else if (y < 0) {
            return x + 1;
        } else {
            return distance[x][y];
        }
    }

    @Test
    public void test() {
        System.out.println(getDistance("Carthorse", "Orchestra"));
    }
}
