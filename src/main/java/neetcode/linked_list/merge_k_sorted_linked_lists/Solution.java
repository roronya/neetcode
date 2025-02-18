package neetcode.linked_list.merge_k_sorted_linked_lists;

import neetcode.linked_list.ListNode;

import java.util.Objects;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return iterationMergeKLists(lists);
    }

    public ListNode iterationMergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (true) {
            int min = -1;
            for (int i = 0; i < lists.length; i++) {
                if (Objects.isNull(lists[i])) continue;
                if (min == -1 || lists[i].val <= lists[min].val) min = i;
            }
            if (min == -1) break;
            cur.next = lists[min];
            cur = cur.next;
            lists[min] = lists[min].next;
        }
        return head.next;
    }

    /**
     * Time Complexity: O(n * k)
     * Space Complexity: O(1)
     */
    public ListNode myMergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode prev = head;
        while (true) {
            //System.out.println(head);
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int j = 0;
            for (int i = 0; i < lists.length; i++) {
                if (Objects.nonNull(lists[i]) && lists[i].val <= min.val) {
                    min = lists[i];
                    j = i;
                }
            }
            prev.next = min;
            prev = prev.next;
            lists[j] = lists[j].next;

            boolean finished = true;
            for (ListNode ln : lists) {
                if (Objects.nonNull(ln)) {
                    finished = false;
                    break;
                }
            }
            if (finished) break;
        }

        return head.next;
    }
}
