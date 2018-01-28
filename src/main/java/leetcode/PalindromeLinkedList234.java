package leetcode;

public class PalindromeLinkedList234 {
	public boolean isPalindrome(ListNode head) {
		if (head == null) return true;

		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode tail = slow;
		ListNode head2 = head;
		while (tail.next != null) {
			ListNode temp = tail.next;
			tail.next = tail.next.next;
			temp.next = head2;
			head2 = temp;
		}

		ListNode middle = head;
		while (head != null && head2 != middle) {
			if (head.val != head2.val) return false;

			head = head.next;
			head2 = head2.next;
		}

		return true;
	}
}
