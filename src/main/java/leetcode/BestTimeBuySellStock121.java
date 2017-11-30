package leetcode;

import java.util.stream.IntStream;

/**
 * Created by honey.and.sw on 2017. 11. 30.
 */
public class BestTimeBuySellStock121 {
    public int maxProfit(int[] prices) {
        // Time Limit Exceeded in this way.
        return IntStream.range(0, prices.length).flatMap(s ->
            IntStream.range(s, prices.length)
                    .filter(e -> prices[e] > prices[s])
                    .map(e -> prices[e] - prices[s])
        ).max().orElse(0);
    }
}
