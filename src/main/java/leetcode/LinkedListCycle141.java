package leetcode;

/**
 * Created by honey.and.sw on 2017. 12. 17.
 */
public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head != null ? head.next : null;

        while (slow != null && fast != null) {
            if (slow.equals(fast)) {
                return true;
            }

            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }

        return false;
    }
}
