package neetcode.sliding_window.permutation_in_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        boolean actual = solution.checkInclusion("abc", "lecabee");
        assertTrue(actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        boolean actual = solution.checkInclusion("abc", "lecaabee");
        assertFalse(actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        boolean actual = solution.checkInclusion("ccc", "cbac");
        assertFalse(actual);
    }


}