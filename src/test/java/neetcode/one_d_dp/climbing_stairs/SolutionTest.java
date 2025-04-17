package neetcode.one_d_dp.climbing_stairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * Input: n = 2
     *
     * Output: 2
     */
    @Test
    void example1() {
        int n = 2;
        Solution solution = new Solution();
        int actual = solution.climbStairs(n);
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: n = 3
     *
     * Output: 3
     */
    @Test
    void example2() {
        int n = 3;
        Solution solution = new Solution();
        int actual = solution.climbStairs(n);
        int expected = 3;
        Assertions.assertEquals(expected, actual);
    }
}