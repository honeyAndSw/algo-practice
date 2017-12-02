package codility;

/**
 * Created by honey.and.sw on 2017. 12. 2.
 */
public class PassingCars {
    public int solution(int[] A) {
        int westsum = 0;
        int cnt = 0;
        int max = 1000000000;

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                westsum++;
            } else {
                cnt += westsum;
            }

            if (cnt > max) {
                return -1;
            }
        }
        return cnt;
    }
}
