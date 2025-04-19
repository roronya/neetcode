package neetcode.one_d_dp.house_robber_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * Input: nums = [3,4,3]
     * <p>
     * Output: 4
     */
    @Test
    void example1() {
        int[] nums = {3, 4, 3};
        Solution solution = new Solution();
        int actual = solution.rob(nums);
        Assertions.assertEquals(4, actual);
    }

    /**
     * Input: nums = [2,9,8,3,6]
     * <p>
     * Output: 15
     */
    @Test
    void example2() {
        int[] nums = {2, 9, 8, 3, 6};
        Solution solution = new Solution();
        int actual = solution.rob(nums);
        Assertions.assertEquals(15, actual);
    }

}