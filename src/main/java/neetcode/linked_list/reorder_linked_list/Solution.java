package neetcode.linked_list.reorder_linked_list;

import neetcode.linked_list.ListNode;

import java.util.Stack;

class Solution {
    //[0, n-1, 1, n-2, 2, n-3, ...]
    public void reorderList(ListNode head) {
        stack(head);
    }

    void stack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        var current = head;
        while (current != null) {
            stack.add(current);
            current = current.next;
        }
        ListNode dummyHead = new ListNode(); //
        ListNode ans = dummyHead;
        var topToTail = head;
        var tailToTop = stack.pop();
        for (int i = 0; i < stack.size() / 2; i++) {
            ans.next = topToTail;
            ans.next.next = tailToTop;
            topToTail = topToTail.next;
            tailToTop = stack.pop();
        }
        if (stack.size() % 2 == 1) {
            ans.next = topToTail;
            ans = ans.next;
        }
        ans.next = null;
        head = dummyHead.next;
    }
}
