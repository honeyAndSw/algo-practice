package etc;

import leetcode.ListNode;

public class InsertInCircularList {
    // 5 -> 8 -> 11 -> 15 -> (...circular...) 5 -> 8 -> ..
    // num = 9
    // circular linked list, non-decreasing ordered
    void insert(ListNode head, int num) {
        ListNode pointer = head;
        while (!(pointer.val <= num && pointer.next.val >= num)) {
            pointer = pointer.next;
        }

        // insert num
        ListNode newNode = new ListNode(num);
        newNode.next = pointer.next;
        pointer.next = newNode;
    }
}
