package neetcode.linked_list.reorder_linked_list;

import neetcode.linked_list.ListNode;

import java.util.Stack;

class Solution {
    //[0, n-1, 1, n-2, 2, n-3, ...]
    public void reorderList(ListNode head) {
        reverseAndMerge(head);
    }

    void reverseAndMerge(ListNode head) {
        System.out.println(head);
        // fastがnullのときslowはちょうど真ん中になる
        // [1,2,3,4] => slow=2, fast=3
        // [1,2,3,4,5] => slow=3,fast=5
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow以降をreverseする
        // [1,2,3,4] => [1,2], [4,3]
        // [1,2,3,4,5] => [1,2,3], [5,4]
        ListNode second = slow.next, prev = null;
        slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }
        System.out.println(head);


        // 前半と後半をくっつける
        // [1,2], [4,3] = >[1,4,2,3,null]
        // [1,2,3], [5,4] => [1,5,2,3,null] => [1,5,2,4,3,null]
        ListNode first = head;
        second = prev;
        while (first != null && second != null) {
            ListNode tmp1 = first.next, tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
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
