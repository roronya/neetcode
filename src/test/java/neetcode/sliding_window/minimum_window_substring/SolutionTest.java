package neetcode.sliding_window.minimum_window_substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        String actual = solution.minWindow("OUZODYXAZV", "XYZ");
        Assertions.assertEquals("YXAZ", actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        String actual = solution.minWindow("xyz", "xyz");
        Assertions.assertEquals("xyz", actual);
    }

    @Test
    void example3() {
        Solution solution = new Solution();
        String actual = solution.minWindow("x", "xy");
        Assertions.assertEquals("", actual);
    }

    @Test
    void example4() {
        Solution solution = new Solution();
        String actual = solution.minWindow("a", "b");
        Assertions.assertEquals("", actual);
    }

    @Test
    void example5() {
        Solution solution = new Solution();
        String actual = solution.minWindow("aa", "aa");
        Assertions.assertEquals("aa", actual);
    }
}