package leetcode;

/**
 * Created by honey.and.sw on 2018. 1. 31.
 */
public class Sqrt69 {

    /*
     * Newton's method is the better solution.
     * https://en.wikipedia.org/wiki/Integer_square_root
     */
    public int mySqrt(int x) {
        int exp100 = 0;
        int divBy100 = x;
        while (divBy100 >= 100) {
            exp100++;
            divBy100 /= 100;
        }

        long sqrt = 1;
        while (exp100-- > 0) sqrt *= 10;

        // When `int` sqrt = 46341, sqrt*sqrt becomes negative.
        // Integer.MAX_VALUE = 2,147,483,647
        while (sqrt * sqrt <= x) {
            sqrt++;
        }

        return (int)sqrt - 1;
    }
}
