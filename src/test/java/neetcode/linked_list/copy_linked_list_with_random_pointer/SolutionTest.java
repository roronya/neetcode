package neetcode.linked_list.copy_linked_list_with_random_pointer;

import neetcode.linked_list.Node;
import neetcode.linked_list.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        List<Integer>[] in = new List[]{
                Arrays.asList(3, null),
                Arrays.asList(7, 3),
                Arrays.asList(4, 0),
                Arrays.asList(5, 1)
        };
        Node head = Node.of(in);
        Node actual = solution.copyRandomList(head);
        Assertions.assertTrue(Utils.deepEquals(head, actual));
    }

}