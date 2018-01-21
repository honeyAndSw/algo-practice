package leetcode;

import java.util.*;

/**
 * Created by honey.and.sw on 2018. 1. 21.
 */
public class ThreeSum15 {

	/**
     * Time Complexity O(N^2)
     * @see <a href="https://discuss.leetcode.com/topic/8125/concise-o-n-2-java-solution">discussion</a>
     */
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < num.length - 2; i++) {
            // Select the first element, unique every time.
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                // Find all available pairs of (lo, hi) of fixed num[i].

                int sum = 0 - num[i]; // expected sum of (lo, hi)
                int lo = i + 1;
                int hi = num.length - 1;

                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));

                        // Skip the same elements to prevent duplicated (lo, hi) pairs.
                        // sum = 1, [-1,-1,0,1,2,2]
                        //           lo          hi
                        // (-1, 2) could be possibly chosen twice.
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }

        return res;
    }

    /**
     * Wrong Answer : [-2,-1,-1,0,1,1,2]
     * In O(N) time, it's impossible to find [-2,0,2], [-2,1,1]
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);

        int head = 0, tail = nums.length - 1;
        List<List<Integer>> list = new LinkedList<>();

        while (tail - head >= 2 && nums[head] <= 0) {
            int s0 = nums[head] + nums[tail];
            int required = -s0;

            if (s0 >= 0) { // find the 3rd element from head
                if (nums[head + 1] <= required) {
                    // nums[head], nums[head+1], .., required, .., nums[tail]
                    int h2 = head + 1;
                    while (h2 + 1 < tail && nums[h2 + 1] <= required) h2++;
                    if (nums[h2] == required) {
                        list.add(Arrays.asList(nums[head], nums[h2], nums[tail]));
                        head++;
                    }
                }
                tail--;
            } else { // if (s0 < 0), find the 3rd element from tail
                if (required <= nums[tail - 1]) {
                    // nums[head], .., required, .., nums[tail-1], nums[tail]
                    int t2 = tail - 1;
                    while (head < t2 - 1 && required <= nums[t2 - 1]) t2--;
                    if (nums[t2] == required) {
                        list.add(Arrays.asList(nums[head], nums[t2], nums[tail]));
                        tail--;
                    }
                }
                head++;
            }
        }

        return list;
    }


    public List<List<Integer>> threeSum0(int[] nums) {
        OptionalInt minOpt = Arrays.stream(nums).min();
        OptionalInt maxOpt = Arrays.stream(nums).max();

        if (minOpt.isPresent() && maxOpt.isPresent()) {
            int min = minOpt.getAsInt();
            int max = maxOpt.getAsInt();

            int LEN = max - min + 1;
            int[] count = new int[LEN];
            Arrays.stream(nums).forEach(n -> count[n - min] += 1);

            return sum(count, 0, min,0, new LinkedList<>());
        }
        return new LinkedList<>();
    }

    private List<List<Integer>> sum(int[] count, int ci, int min, int sum, LinkedList<Integer> selected) {
        System.out.println("ci:" + ci
                + ", sum:" + sum
                + ", selected:" + Arrays.toString(((List<Integer>)selected.clone()).toArray()));

        if (sum == 0 && selected.size() == 3) {
            LinkedList<List<Integer>> wrapper = new LinkedList<>();
            wrapper.add((List<Integer>) selected.clone());
            return wrapper;
        } else if (ci >= count.length || sum > 0 || selected.size() >= 3) {
            return null;
        }

        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> newSelected = (LinkedList<Integer>) selected.clone();

        for (int c = 0; c <= count[ci]; c++) {
            if (c > 0) {
                newSelected.add(ci + min);
            }

            int nextCi = ci + 1;
            while (count[nextCi] == 0) nextCi++;

            List<List<Integer>> partialResult = sum(count, nextCi, min,
                    sum + (ci + min) * c, newSelected);
            if (partialResult != null) {
                result.addAll(partialResult);
            }
        }

        return result;
    }
}
