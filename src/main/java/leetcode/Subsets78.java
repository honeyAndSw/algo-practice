package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by honey.and.sw on 2018. 1. 30.
 */
public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = subsets(nums, 0, new LinkedList<>());
        subsets.add(
                Arrays.stream(nums).boxed().collect(Collectors.toList())
        );
        if (nums.length > 0) {
            subsets.add(new ArrayList<>());
        }
        return subsets;
    }

    private List<List<Integer>> subsets(int[] nums, int idx, List<Integer> base) {
        List<List<Integer>> result = new LinkedList<>();
        if (base.size() == nums.length - 1) return result;

        for (int i = idx; i < nums.length; i++) {
            base.add(nums[i]);
            result.add(new LinkedList<>(base));
            List<List<Integer>> nextSubsets = subsets(nums, i+1, base);
            if (nextSubsets.size() > 0) {
                result.addAll(nextSubsets);
            }
            base.remove(base.size() - 1);
        }

        return result;
    }
}
