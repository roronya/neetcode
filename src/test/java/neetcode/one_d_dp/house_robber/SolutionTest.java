package neetcode.one_d_dp.house_robber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * Input: nums = [1,1,3,3]
     *
     * Output: 4
     */
    @Test
    void example1() {
        int[] nums = {1,1,3,3};
        Solution solution = new Solution();
        int actual = solution.rob(nums);
        Assertions.assertEquals(4, actual);
    }

    /**
     * Input: nums = [2,9,8,3,6]
     *
     * Output: 16
     */
    @Test
    void example2() {
        int[] nums = {2,9,8,3,6};
        Solution solution = new Solution();
        int actual = solution.rob(nums);
        Assertions.assertEquals(16, actual);
    }
}