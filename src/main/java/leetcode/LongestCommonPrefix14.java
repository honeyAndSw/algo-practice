package leetcode;

/**
 * Created by honey.and.sw on 2017. 12. 28.
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        int N = strs.length;

        String prefix = "";
        boolean flag = strs.length != 0;
        int i = 0;

        while (flag) {
            String next = "";
            for (int n = 0; n < N; n++) {
                if (i >= strs[n].length()) {
                    flag = false;
                    break;
                } else if (next.equals("")) {
                    next = strs[n].charAt(i) + "";
                } else if (!next.equals(strs[n].charAt(i) + "")) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                prefix += next;
                i++;
            }
        }

        return prefix;
    }
}
