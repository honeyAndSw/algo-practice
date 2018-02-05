package leetcode;

public class ReverseNodesInKGroup25 {

	/* Recursive Solution */
	public ListNode reverseKGroup(ListNode head, int k) {
		// Move tail k steps.
		ListNode tail = head;
		int move = 0;
		while (tail != null && move + 1 < k) {
			tail = tail.next;
			move++;
		}

		if (tail == null) return head;

		ListNode newHead = tail.next;

		// Reverse (head -> ... -> tail) to (tail -> ... -> head)
		tail.next = null;
		ListNode reversed = reverse(head);
		// ListNode reversedTail = reversed;
		// while (reversedTail.next != null) reversedTail = reversedTail.next;
		// reversedTail.next = reverseKGroup(newHead, k);
		// `head` becomes `reversed tail`.
		head.next = reverseKGroup(newHead, k);

		return reversed;
	}

	public ListNode reverseKGroup0(ListNode head, int k) {
        ListNode tail = head;
        int move = 0;

        ListNode newHead = null;
        ListNode newTail = null;

        while (k > 1 && tail != null) {
            // check
            if (move > 0 && (move + 1) % k == 0) {
                ListNode nextHead = tail.next;
                tail.next = null;

                ListNode reversed = reverse(head);
                if (newTail == null) {
                    newHead = reversed;
                    newTail = newHead;
                } else {
                    newTail.next = reversed;
                }

                while (newTail.next != null) {
                    newTail = newTail.next;
                }

                // reset
                head = nextHead;
                tail = head;
                move = 0;
            } else {
                // move
                tail = tail.next;
                move++;
            }
        }

        if (newHead == null) {
            return head;
        } else {
            newTail.next = head;
            return newHead;
        }
	}

	private ListNode reverse(ListNode head) {
		ListNode newHead = null;

		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}

		return newHead;
	}
}
