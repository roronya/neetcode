package neetcode.linked_list.reverse_node_in_k_group;

import neetcode.linked_list.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        ListNode head = ListNode.of(1, 2, 3, 4, 5, 6);
        int k = 3;
        ListNode actual = solution.reverseKGroup(head, k);
        Assertions.assertEquals(ListNode.of(3, 2, 1, 6, 5, 4), actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        int k = 3;
        ListNode actual = solution.reverseKGroup(head, k);
        Assertions.assertEquals(ListNode.of(3, 2, 1, 4, 5), actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        int k = 2;
        ListNode actual = solution.reverseKGroup(head, k);
        Assertions.assertEquals(ListNode.of(2, 1, 4, 3, 5), actual);
    }

    @Test
    void example4() {
        Solution solution = new Solution();
        ListNode head = ListNode.of(1, 2, 3, 4, 5, 6);
        int k = 2;
        ListNode actual = solution.reverseKGroup(head, k);
        Assertions.assertEquals(ListNode.of(2, 1, 4, 3, 6, 5), actual);
    }
}