package leetcode;

/**
 * Created by honey.and.sw on 2018. 1. 21.
 */
public class ProductArrayExceptSelf238 {
    public int[] productExceptSelf1(int[] nums) {
        int N = nums.length;
        int[] beforeSelf = new int[N];
        int[] afterSelf = new int[N];

        beforeSelf[0] = 1;
        for (int i = 1; i < N; i++) beforeSelf[i] = beforeSelf[i-1] * nums[i-1];

        afterSelf[N-1] = 1;
        for (int i = N-2; i >= 0; i--) afterSelf[i] = afterSelf[i+1] * nums[i+1];

        int[] product = new int[N];
        for (int i = 0; i < N; i++) product[i] = beforeSelf[i] * afterSelf[i];

        return product;
    }

    /**
     * Follow up:
     * Could you solve it with constant space complexity?
     * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
     */
    public int[] productExceptSelf2(int[] nums) {
        int N = nums.length;

        int[] product = new int[N];
        product[0] = 1;

        for (int i = 1; i < N; i++) product[i] = product[i-1] * nums[i-1];

        int after = 1;
        for (int i = N-1; i >= 0; i--) {
            product[i] *= after;
            after *= nums[i];
        }

        return product;
    }
}
