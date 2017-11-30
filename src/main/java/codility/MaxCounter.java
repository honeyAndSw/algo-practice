package codility;

/**
 * Created by honey.and.sw on 2017. 11. 30.
 */
public class MaxCounter {

    public int[] solution2(int N, int[] A) {
        int M = A.length;

        int[] counters = new int[N];
        int start = 0, end = 0, max = 0, base = 0;
        while (end <= M && start < M) {
            if (end < M && A[start] == A[end]) {
                end++;
                continue;
            }

            if (A[start] <= N) {
                counters[A[start] - 1] += (end - start);
                max = Math.max(max, counters[A[start] - 1]);
            } else {
                base += max;
                max = 0;
                counters = new int[N];
            }

            start = end;
        }

        for (int i = 0; i < N; i++) {
            counters[i] += base;
        }

        return counters;
    }

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0, base = 0;

        for (int a : A) {
            if (a <= N) {
                counters[a - 1]++;
                max = Math.max(max, counters[a - 1]);
            } else {
                base += max;
                max = 0;
                counters = new int[N];
            }
        }

        for (int i = 0; i < N; i++) {
            counters[i] += base;
        }

        return counters;
    }
}
