package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by honey.and.sw on 2017. 12. 17.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    public ListNode(List<Integer> values) {
        this.val = values.get(0);
        this.next = values.size() > 1 ? new ListNode(values.subList(1, values.size())) : null;
    }

    public int[] toArray() {
        List<Integer> list = new LinkedList<>();

        ListNode p = this;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
