package leetcode;

/**
 * Created by honey.and.sw on 2018. 1. 21.
 */
public class RemoveDupsSortedArray26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int front = 0, back = 0;

        while (back < nums.length) {
            if (nums[back] > nums[front]) {
                front++;
                if (front != back) {
                    int temp = nums[front];
                    nums[front] = nums[back];
                    nums[back] = temp;
                }
            }

            back++;
        }

        return front + 1;
    }
}
