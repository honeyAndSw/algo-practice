package codility;

/**
 * Created by honey.and.sw on 2017. 12. 1.
 */
public class CountDiv {
    /**
     * Solution should satisfy these cases:
     *   A, B within the range [0..2,000,000,000]
     *   example, simple
     *   minimal
     *     A = B in {0,1}, K = 11
     *   extreme_ifempty
     *     A = 10, B = 10, K in {5,7,10}
     *   extreme_endpoints
     *     verify handling of range endpoints, multiple runs
     *   big_values
     *     A = 100, B = 123M+, K=2
     *     A = 101, B = 123M+, K=10K
     *     A = 0, B = MAXINT, K in {1,MAXINT}
     *     A, B, K in {1,MAXINT}
     *
     * @param A
     * @param B
     * @param K
     * @return
     */
    public int solution(int A, int B, int K) {
        if (B < K) {
            return A == 0 ? 1 : 0;
        } else {
            int start = (A > 0 && A < K) ? K : A + (A % K);
            int end = B - (B % K);
            return end < start ? 0 : (end - start) / K + 1;
        }
    }

    public int solution0(int A, int B, int K) {
        if (K == 1) return B - A + 1;

        int start = (A > 0 && A < K) ? K : A + (A % K);
        int count = 0;
        while (start >= A && start <= B) {
            count++;
            start += K;
        }

        return count;
    }
}
