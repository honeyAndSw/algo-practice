package algostrategies.dptechnique09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Packing {

    private static int N;
    private static int W;
    private static String[] ITEMS = new String[101];
    private static int[] WEIGHT = new int[101];
    private static int[] WANT = new int[101];
    private static int[][] CACHE = new int[1001][101];
    private static Set<Integer> IS_ITEM_IN = new HashSet<>();

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int tests = Integer.parseInt(reader.readLine());
        while (tests-- > 0) {
            // 변수 초기화
            IS_ITEM_IN.clear();
            for (int i = 0; i < 1001; i++) {
                Arrays.fill(CACHE[i], -1);
            }
            Arrays.fill(ITEMS, "");
            Arrays.fill(WANT, -1);
            Arrays.fill(WEIGHT, -1);

            String[] def = reader.readLine().split(" ");
            N = Integer.parseInt(def[0]);
            W = Integer.parseInt(def[1]);

            for (int i = 0; i < N; i++) {
                String[] belonging = reader.readLine().split(" ");
                ITEMS[i] = belonging[0];
                WEIGHT[i] = Integer.parseInt(belonging[1]);
                WANT[i] = Integer.parseInt(belonging[2]);
            }

            int maxWant = pack(0, W);
            setIsItemIn(0, W);

            System.out.printf("%d %d\n", maxWant, IS_ITEM_IN.size());
            for (Integer index : IS_ITEM_IN) {
                System.out.println(ITEMS[index]);
            }
        }
    }

    public static void setValues(int[] weight, int[] want, int n, int w) {
        IS_ITEM_IN.clear();
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(CACHE[i], -1);
        }
        WEIGHT = weight;
        WANT = want;
        N = n;
        W = w;
    }

    /**
     * @param index Index of items
     * @param capacity Available capacity
     * @return Max sum of how much item is wanted.
     */
    public static int pack(int index, int capacity) {
        if (index >= N) return 0;
        else if (CACHE[capacity][index] != -1) return CACHE[capacity][index];

        // Pack without item[index]
        int max = pack(index + 1, capacity);

        if (capacity >= WEIGHT[index]) {
            // Pack with item[index] if there's enough room for it.
            max = Math.max(
                max,
                pack(index + 1, capacity - WEIGHT[index]) + WANT[index]);
        }

        CACHE[capacity][index] = max;
        return max;
    }

    public static void setIsItemIn(int index, int capacity) {
        if (index >= N) return;
        if (pack(index, capacity) == pack(index + 1, capacity)) {
            // Because item didn't affect whole capacity, it is not selected.
            setIsItemIn(index + 1, capacity);
        } else {
            IS_ITEM_IN.add(index);
            setIsItemIn(index + 1, capacity - WEIGHT[index]);
        }
    }
}
