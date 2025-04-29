package neetcode.one_d_dp.maximum_product_subarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * Input: nums = [1,2,-3,4]
     *
     * Output: 4
     */
    @Test
    void example1() {
        int[] nums = {1,2,-3,4};
        Solution solution = new Solution();
        int actual = solution.maxProduct(nums);
        Assertions.assertEquals(4, actual);
    }

    /**
     * Input: nums = [-2,-1]
     *
     * Output: 2
     */
    @Test
    void example2() {
        int[] nums = {-2, -1};
        Solution solution = new Solution();
        int actual = solution.maxProduct(nums);
        Assertions.assertEquals(2, actual);
    }
}