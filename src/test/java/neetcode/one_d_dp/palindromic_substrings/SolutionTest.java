package neetcode.one_d_dp.palindromic_substrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * Input: s = "abc"
     * <p>
     * Output: 3
     */
    @Test
    void example1() {
        String s = "abc";
        Solution solution = new Solution();
        int actual = solution.countSubstrings(s);
        Assertions.assertEquals(3, actual);
    }

    /**
     * Input: s = "aaa"
     * <p>
     * Output: 6
     */
    @Test
    void example2() {
        String s = "aaa";
        Solution solution = new Solution();
        int actual = solution.countSubstrings(s);
        Assertions.assertEquals(6, actual);
    }

    /**
     * s="abbaabbaabbaabbaabbaabbaabbaabbaabbaabbaabbaabba"
     * expected: 336
     */
    @Test
    void example3() {
        String s = "abbaabbaabbaabbaabbaabbaabbaabbaabbaabbaabbaabba";
        Solution solution = new Solution();
        int actual = solution.countSubstrings(s);
        Assertions.assertEquals(336, actual);
    }

}