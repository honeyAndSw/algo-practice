package algostrategies.dp08;

import java.util.Arrays;
import java.util.Scanner;

public class Pi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            String str = sc.next();
            char[] chars = str.toCharArray();
            int[] seq = new int[str.length()];
            for (int j = 0; j < seq.length; j++) {
                seq[j] = Integer.parseInt(chars[j] + "");
            }
            System.out.println(level(seq));
        }
    }

    public static int level(int[] seq) {
        int[] cache = new int[seq.length];
        Arrays.fill(cache, -1);
        return level(seq, cache, 0);
    }

    public static int level(int[] seq, int[] cache, int idx) {
        if (idx >= seq.length) return 0;
        else if (cache[idx] != -1) return cache[idx];

        int level = Math.min(find(seq, idx, idx + 2) + level(seq, cache, idx + 3),
                    Math.min(find(seq, idx, idx + 3) + level(seq, cache, idx + 4),
                            find(seq, idx, idx + 4) + level(seq, cache, idx + 5)
                    ));
        cache[idx] = level;
        return level;
    }

    public static int find(int[] seq, int s, int e) {
        // Modify e to fit into seq range.
        e = Math.min(e, seq.length - 1);

        // Unknown level.
        if (e - s < 2) return 10;

        int[] sub = new int[e - s + 1];
        for (int i = s; i <= e; i++) sub[i - s] = seq[i];

        if (allEquals(sub)) return 1;

        int[] diff = new int[sub.length - 1];
        for (int i = 0; i < sub.length - 1; i++) diff[i] = sub[i] - sub[i + 1];

        // [FIX] level 4 should have higher priority than level 5, so delay to return level 5.
        // if (allEquals(diff)) return Math.abs(diff[0]) == 1 ? 2 : 5;
        if (allEquals(diff) && Math.abs(diff[0]) == 1) return 2;

        boolean isAlternating = true;
        for (int i = 0; i < sub.length - 2; i++) {
            if (sub[i] != sub[i + 2]) isAlternating = false;
        }

        // [FIX] Figured out that using diffAbs is too generous to find level 4,
        // for example: {8,7,6,7} ==> its diff {1,1,-1} ==> its diffAbs {1,1,1}
        // int[] diffAbs = new int[diff.length];
        // for (int i = 0; i < diffAbs.length; i++) diffAbs[i] = Math.abs(diff[i]);
        // if (allEquals(diffAbs) && sub[0] == sub[2]) return 4;
        if (isAlternating) return 4;
        else if (allEquals(diff) && Math.abs(diff[0]) > 1) return 5;
        return 10;
    }

    private static boolean allEquals(int[] arr) {
        int comp = arr[0];
        for (int a : arr) {
            if (comp != a) return false;
        }
        return true;
    }
}
