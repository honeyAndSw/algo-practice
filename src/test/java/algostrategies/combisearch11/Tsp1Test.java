package algostrategies.combisearch11;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by honey.and.sw on 2017. 11. 5.
 */
public class Tsp1Test {
    @Test
    public void test_example1() throws Exception {
        Tsp1.distances = new double[][]{
            {0.0000000000, 611.6157225201, 648.7500617289},
            {611.6157225201, 0.0000000000, 743.8557967501},
            {648.7500617289, 743.8557967501, 0.0000000000}
        };
        assertEquals(1260.3657842490, Tsp1.tsp1(), Math.exp(-7));
    }

    @Test
    public void test_example2() throws Exception {
        Tsp1.distances = new double[][]{
            {0.0000000000, 326.0008994586, 503.1066076077, 290.0250922998},
            {326.0008994586, 0.0000000000, 225.1785728436, 395.4019367384},
            {503.1066076077, 225.1785728436, 0.0000000000, 620.3945520632},
            {290.0250922998, 395.4019367384, 620.3945520632, 0.0000000000}
        };
        assertEquals(841.2045646020, Tsp1.tsp1(), Math.exp(-7));
    }
}