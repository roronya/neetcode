package neetcode.one_d_dp.min_cost_climbing_stairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * Input: cost = [1,2,3]
     *
     * Output: 2
     */
    @Test
    void example1() {
        int[] cost = {1,2,3};
        Solution solution = new Solution();
        int actual = solution.minCostClimbingStairs(cost);
        Assertions.assertEquals(2, actual);
    }
    /**
     * Input: cost = [1,2,1,2,1,1,1]
     *
     * Output: 4
     */
    @Test
    void example2() {
        int[] cost = {1,2,1,2,1,1,1};
        Solution solution = new Solution();
        int actual = solution.minCostClimbingStairs(cost);
        Assertions.assertEquals(4, actual);
    }
}