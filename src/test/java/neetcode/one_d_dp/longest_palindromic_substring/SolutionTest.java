package neetcode.one_d_dp.longest_palindromic_substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * Input: s = "ababd"
     * <p>
     * Output: "bab"
     */
    @Test
    void example1() {
        String s = "ababd";
        Solution solution = new Solution();
        String actual = solution.longestPalindrome(s);
        String expected = "bad";
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: s = "abbc"
     * <p>
     * Output: "bb"
     */
    @Test
    void example2() {
        String s = "abbd";
        Solution solution = new Solution();
        String actual = solution.longestPalindrome(s);
        String expected = "bb";
        Assertions.assertEquals(expected, actual);
    }
}