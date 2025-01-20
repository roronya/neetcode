package neetcode.linked_list.merge_two_sorted_linked_list;

import neetcode.linked_list.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            current.next = new ListNode(Math.min(list1.val, list2.val));
            current = current.next;
            if (list1.val < list2.val) list1 = list1.next;
            else list2 = list2.next;
        }
        while (list1 != null) {
            current.next = new ListNode(list1.val);
            current = current.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            current.next = new ListNode(list2.val);
            current = current.next;
            list2 = list2.next;
        }

        return dummyHead.next;
    }
}
