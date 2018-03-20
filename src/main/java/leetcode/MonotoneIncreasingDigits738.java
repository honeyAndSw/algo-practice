package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by honey.and.sw on 2018. 3. 20.
 */
public class MonotoneIncreasingDigits738 {
    // TODO N to String type
    // TODO No recursion
    public int monotoneIncreasingDigits(int N) {
        List<Integer> num = null;

        List<Integer> sameStart = new LinkedList<>();
        sameStart.add(num.get(0));
        List<Integer> backtrack = backtrack(num, sameStart);

        if (backtrack != null) return toInteger(backtrack);
        else {
            List<Integer> smaller = new LinkedList<>();
            for (int i = 0; i < smaller.size(); i++) smaller.add(i == 0 ? num.get(0) - 1 : 9);
            return toInteger(smaller);
        }
    }

    private int toInteger(List<Integer> num) {
        return 0;
    }

    private List<Integer> backtrack(List<Integer> num, List<Integer> path) {
        if (num.size() == path.size()) return path;

        //       i
        // - - - - -
        // - - -
        int idx = path.size();
        int max = num.get(idx-1) > path.get(idx-1) ? 9 : num.get(idx);
        int min = path.get(idx-1);

        for (int n = max; n >= min; n--) {
            path.add(n);
            List<Integer> result = backtrack(num, path);
            if (result != null) return result;
            path.remove(path.size() - 1);
        }

        return null;
    }
}
