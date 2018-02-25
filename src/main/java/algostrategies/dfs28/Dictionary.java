package algostrategies.dfs28;

/**
 * Created by honey.and.sw on 2018. 2. 19.
 */
public class Dictionary {
    /**
     * @param alphabets a,b,c,d,e,..,k,...
     * @param dict
     * @param ds starting index of dict
     * @param de end index of dict
     * @param pos
     */
    void order(char[] alphabets, String[] dict, int ds, int de, int pos) {
        // 0
        // i s ------0
        //   1
        // o r dered --- ds2
        // o r dinary
        // o r ddddd --- de2
        // t his di
        int di = ds + 1;
        while (di <= de) {
            if (dict[di-1].charAt(pos) != dict[di].charAt(pos)) {
                // ?? graph 같은 일을 한다.
                // swap alphabets' positions
                char ch1 = dict[di-1].charAt(pos);
                char ch2 = dict[di].charAt(pos);
            } else {
                int ds2 = di -1;

                while (dict[di-1].charAt(pos) == dict[di].charAt(pos)) di++;
                int de2 = di - 1;
                order(alphabets, dict, ds2, de2, pos + 1);
            }
        }
    }
}
