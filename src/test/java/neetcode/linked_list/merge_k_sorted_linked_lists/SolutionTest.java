package neetcode.linked_list.merge_k_sorted_linked_lists;

import neetcode.linked_list.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[]{
                ListNode.of(1, 2, 4),
                ListNode.of(1, 3, 5),
                ListNode.of(3, 6)
        };

        ListNode actual = solution.mergeKLists(lists);

        Assertions.assertEquals(ListNode.of(1, 1, 2, 3, 3, 4, 5, 6), actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[]{};
        ListNode actual = solution.mergeKLists(lists);
        Assertions.assertEquals(ListNode.of(), actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[]{ListNode.of()};
        ListNode actual = solution.mergeKLists(lists);
        Assertions.assertEquals(ListNode.of(), actual);
    }

}