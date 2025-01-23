package neetcode.linked_list.find_the_duplicate_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int actual = solution.findDuplicate(new int[]{1, 2, 3, 2, 2});
        Assertions.assertEquals(2, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int actual = solution.findDuplicate(new int[]{1, 2, 3, 4, 4});
        Assertions.assertEquals(4, actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        int actual = solution.findDuplicate(new int[]{1, 3, 4, 2, 2});
        Assertions.assertEquals(2, actual);
    }
}