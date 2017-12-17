package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by honey.and.sw on 2017. 12. 17.
 */
public class LinkedListCycle141Test {
    LinkedListCycle141 solution = new LinkedListCycle141();

    @Test
    public void test1() throws Exception {
        ListNode n1 = new ListNode(1);
        assertFalse(solution.hasCycle(n1));

        assertFalse(solution.hasCycle(null));
    }

    @Test
    public void test2() throws Exception {
        // n1(1) -> n1(1) -> ...
        ListNode n1 = new ListNode(1);
        n1.next = n1;
        assertTrue(solution.hasCycle(n1));
    }

    @Test
    public void test3() throws Exception {
        // n1(1) -> n2(2) -> n1(1) -> ...
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;

        assertTrue(solution.hasCycle(n1));
    }

    @Test
    public void test4() throws Exception {
        // n1(1) -> n2(2) -> null
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        assertFalse(solution.hasCycle(n1));
    }

    @Test
    public void test5() throws Exception {
        // n1(1) -> n2(2) -> n3(3) -> n2(2) -> ...
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n2;

        assertTrue(solution.hasCycle(n1));
    }
}