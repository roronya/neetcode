package neetcode.linked_list.merge_k_sorted_linked_lists;

import neetcode.linked_list.ListNode;

import java.util.Objects;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
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
