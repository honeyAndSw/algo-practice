package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 12. 16.
 */
public class MajorityElement169Test {
    MajorityElement169 solution = new MajorityElement169();

    @Test
    public void test2() throws Exception {
        assertEquals(5, solution.majorityElement(new int[]{6,5,5}));
    }
}