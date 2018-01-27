package leetcode;

public class ReverseLinkedList206 {

	/* Recursive */
	public ListNode reverseList(ListNode head) {
		return reverseHelper(head, null);
	}

	private ListNode reverseHelper(ListNode old, ListNode nue) {
		if (old == null) return nue;
		else {
			ListNode first = old;
			ListNode second = old.next;
			first.next = nue;
			return reverseHelper(second, first);
		}
	}

	/* Iterative */
	public ListNode reverseList1(ListNode head) {
		ListNode newHead = head;

		while (head != null && head.next != null) {
			ListNode h1 = head.next; // ListNode target to move front
			head.next = head.next.next;
			h1.next = newHead;
			newHead = h1;
		}

		return newHead;
	}
}
