package array;

import java.util.List;
import java.util.Random;

/**
 * Created by awang1 on 6/23/15.
 */
public class RandomSampling {
    public <T> List<T> sample(List<T> data, int k) {
        int seen = 0;
        Random r = new Random();
        T current;
        for (T t: data) {
            current = t;
            if (seen > k) {
                if (r.nextInt(seen) < k) {
                    data.set(r.nextInt(k), current);
                }
            }
        }
        return data;
    }
}
