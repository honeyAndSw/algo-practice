package algostrategies.dptechnique09;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 9. 27.
 */
public class PackingTest {

    @Test
    public void test_maxInput() throws Exception {
        /* laptop       4 7  <--
           camera       2 10 <--
           xbox         6 6
           grinder      4 7  <--
           dumbell      2 5
           encyclopedia 10 4 */
        Packing.setValues(new int[]{99, 99, 99, 99, 99, 99}, new int[]{99, 99, 99, 99, 99, 99}, 6, 1000);
        int packed = Packing.pack(0, 1000);
    }

    @Test
    public void example1() throws Exception {
        /* laptop       4 7  <--
           camera       2 10 <--
           xbox         6 6
           grinder      4 7  <--
           dumbell      2 5
           encyclopedia 10 4 */
        Packing.setValues(new int[]{4, 2, 6, 4, 2, 10}, new int[]{7, 10, 6, 7, 5, 4}, 6, 10);
        int packed = Packing.pack(0, 10);
        assertEquals(24, packed);
    }

    @Test
    public void example1_순서바꿈() throws Exception {
        /* encyclopedia 10 4
           camera       2 10 <--
           xbox         6 6
           grinder      4 7  <--
           dumbell      2 5
           laptop       4 7  <--*/
        Packing.setValues(new int[]{10, 2, 6, 4, 2, 4}, new int[]{4, 10, 6, 7, 5, 7}, 6, 10);
        int packed = Packing.pack(0, 10);
        assertEquals(24, packed);
    }

    @Test
    public void example2() throws Exception {
        /* laptop       4 7  <--
           camera       2 10 <--
           xbox         6 6  <--
           grinder      4 7  <--
           dumbell      2 5
           encyclopedia 10 4 */
        Packing.setValues(new int[]{4, 2, 6, 4, 2, 10}, new int[]{7, 10, 6, 7, 5, 4}, 6, 17);
        int packed = Packing.pack(0, 17);
        assertEquals(30, packed);
    }
}