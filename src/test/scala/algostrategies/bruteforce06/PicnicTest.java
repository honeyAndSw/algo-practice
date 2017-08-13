package algostrategies.bruteforce06;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 8. 13.
 */
public class PicnicTest {
    boolean F = false, T = true;

    @Test
    public void countFriends1() throws Exception {
        boolean[][] friends = {
            {F, T, T, T},
            {T, F, T, T},
            {T, T, F, T},
            {T, T, T, F}
        };

        Set<Integer> students = new LinkedHashSet<>();
        for (int i = 0; i < 4; i++) students.add(i);

        assertEquals(3, Picnic.countFriends(friends, students));
    }
}