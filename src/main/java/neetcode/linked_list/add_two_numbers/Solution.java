package neetcode.linked_list.add_two_numbers;

import neetcode.linked_list.ListNode;

import java.util.Objects;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return mySolution(l1, l2);
    }

    /**
     * time complexity: O(n)
     * space complexity: O(1)
     */
    ListNode mySolution(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        int carry = 0;
        while (!(l1 == null && l2 == null)) {
            int sum = (Objects.isNull(l1) ? 0 : l1.val) + (Objects.isNull(l2) ? 0 : l2.val) + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            prev.next = node;
            prev = node;
            l1 = (Objects.isNull(l1) ? null : l1.next);
            l2 = (Objects.isNull(l2) ? null : l2.next);
        }
        if (carry != 0) prev.next = new ListNode(carry);
        return dummy.next;
    }
}

