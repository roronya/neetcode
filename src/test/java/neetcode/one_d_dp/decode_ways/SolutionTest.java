package neetcode.one_d_dp.decode_ways;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void check() {
        System.out.println('Z' - 'A');
    }

    /**
     * Input: s = "12"
     * <p>
     * Output: 2
     * <p>
     * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
     */
    @Test
    void example1() {
        String s = "12";
        Solution solution = new Solution();
        int actual = solution.numDecodings(s);
        Assertions.assertEquals(2, actual);
    }

    /**
     * Input: s = "01"
     * <p>
     * Output: 0
     */
    @Test
    void example2() {
        String s = "01";
        Solution solution = new Solution();
        int actual = solution.numDecodings(s);
        Assertions.assertEquals(0, actual);
    }

}