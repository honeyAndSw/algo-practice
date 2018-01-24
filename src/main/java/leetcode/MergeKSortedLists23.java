package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * MergeKSortedLists23
 *
 * @author naheon
 * @since 2018. 01. 24.
 */
public class MergeKSortedLists23 {
	public ListNode mergeKLists(ListNode[] lists) {
		return merge(lists, 0, lists.length - 1);
	}

	private ListNode merge(ListNode[] lists, int from, int to) {
		if (from > to || lists == null) return null;
		else if (from == to) return lists[from];
		else if (to - from == 1) return merge(lists[from], lists[to]);
		else {
			int mid = (from + to) / 2;
			ListNode first = merge(lists, from, mid);
			ListNode second = merge(lists, mid + 1, to);
			return merge(first, second);
		}
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}

		ListNode head = head1.val <= head2.val ? head1 : head2;
		ListNode p1 = head;
		ListNode p2 = head1.val <= head2.val ? head2 : head1;

		while (p1.next != null && p2 != null) {
			if (p1.val <= p2.val && p1.next.val >= p2.val) {
				// p1 -> p2 -> p1.next
				ListNode temp = p2;
				p2 = p2.next;
				temp.next = p1.next;
				p1.next = temp;
			}

			p1 = p1.next;
		}

		if (p2 != null) {
			p1.next = p2;
		}

		return head;
	}

	/* Time Limit Exceeded */
	public ListNode mergeKLists0(ListNode[] lists) {
		/*
		 There are three general-purpose Set implementations — HashSet, TreeSet, and LinkedHashSet.
		 Which of these three to use is generally straightforward. HashSet is much faster than TreeSet
		 (constant-time versus log-time for most operations) but offers no ordering guarantees.
		 If you need to use the operations in the SortedSet interface, or if value-ordered iteration
		 is required, use TreeSet; otherwise, use HashSet. It's a fair bet that you'll end up using HashSet
		 most of the time.
		 https://docs.oracle.com/javase/tutorial/collections/implementations/set.html
		*/
		Set<ListNode> pointers = new HashSet<>();
		for (ListNode ln : lists) {
			if (ln != null) {
				pointers.add(ln);
			}
		}

		ListNode head = null, tail = null;
		while (!pointers.isEmpty()) {
			ListNode min = null;
			for (ListNode pointer : pointers) {
				if (min == null || min.val > pointer.val) {
					min = pointer;
				}
			}

			if (head == null) {
				head = min;
				tail = min;
			} else {
				tail.next = min;
				tail = tail.next;
			}

			// Update min pointer
			pointers.remove(min);
			if (min.next != null) {
				min = min.next;
				pointers.add(min);
			}
		}

		return head;
	}
}
