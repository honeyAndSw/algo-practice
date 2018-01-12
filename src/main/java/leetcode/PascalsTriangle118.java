package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by honey.and.sw on 2018. 1. 12.
 */
public class PascalsTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(Arrays.asList(1));

        IntStream.range(1, numRows).forEach(i -> {
            List<Integer> upper = result.get(i - 1);

            List<Integer> row = IntStream.range(0, i + 1)
                    .map(j -> (j == 0 || j == i) ? 1 : upper.get(j) + upper.get(j - 1))
                    .boxed()
                    .collect(Collectors.toList());

            result.add(row);
        });

        return result;
    }
}
