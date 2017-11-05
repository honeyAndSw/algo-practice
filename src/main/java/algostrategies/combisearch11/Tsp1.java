package algostrategies.combisearch11;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by honey.and.sw on 2017. 11. 5.
 */
public class Tsp1 {
    public static double[][] distances;
    public static double[][] cache;

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int len = sc.nextInt();
            distances = new double[len][len];
            for (int i : IntStream.range(0, len).toArray()) {
                for (int j : IntStream.range(0, len).toArray()) {
                    distances[i][j] = sc.nextDouble();
                }
            }
            System.out.println(String.format(tsp1() + "", "%.10f"));
        }
    }

    public static double tsp1() {
        int length = distances[0].length;

        // Initialize cache
        cache = new double[length][1 << length];
        IntStream.range(0, length)
            .forEach(idx -> Arrays.fill(cache[idx], -1));

        // Start a path from every possible point and pick minimum.
        return IntStream.range(0, length)
            .mapToDouble((int idx) -> tsp1(1 << idx, idx))
            .min()
            .getAsDouble();
    }

    /**
     * TSP with memoization
     */
    public static double tsp1(int visited, int now) {
        int length = distances[0].length;
        if (visited == ((1 << length) - 1)) {
            return 0;
        }

        if (cache[now][visited] > -1) return cache[now][visited];

        double min = Long.MAX_VALUE;
        for (int next = 0; next < length; next++) {
            int mask = 1 << next;
            if ((visited & mask) == mask) continue;

            min = Math.min(min,
                tsp1(visited | mask, next) + distances[next][now]
            );
        }

        cache[now][visited] = min;
        return min;
    }

    public static double tsp0(int visited, int now, double accum) {
        int length = distances[0].length;
        if (visited == ((1 << length) - 1)) {
            return accum;
        }

        if (cache[now][visited] > -1) {
            return cache[now][visited];
        }

        double min = Long.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int mask = 1 << i;
            if ((visited & mask) == mask) continue;
            min = Math.min(min, tsp0(visited | mask, i, accum + distances[i][now]));
        }

        cache[now][visited] = min;
        return min;
    }
}
