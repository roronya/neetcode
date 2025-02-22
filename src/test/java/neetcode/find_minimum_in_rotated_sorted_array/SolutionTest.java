package neetcode.find_minimum_in_rotated_sorted_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    /**
     * right < left < pivot => rightを探索すべき => leftをpivot+1
     */
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] nums = {3, 4, 5, 6, 1, 2};
        int actual = solution.findMin(nums);
        Assertions.assertEquals(1, actual);
    }

    /**
     * pivot < left < right => leftを探索すべき => rightをpivot - 1
     */
    @Test
    void example2() {
        Solution solution = new Solution();
        int[] nums = {4, 5, 0, 1, 2, 3};
        int actual = solution.findMin(nums);
        Assertions.assertEquals(0, actual);
    }

    /**
     * left < pivot < right => leftを探索すべき => rightをpivot - 1
     */
    @Test
    void example3() {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7};
        int actual = solution.findMin(nums);
        Assertions.assertEquals(4, actual);
    }

    /**
     * right < pivot = left => rightを探索すべき => leftをpivot + 1
     */
    @Test
    void example4() {
        Solution solution = new Solution();
        int[] nums = {2, 1};
        // [2,1] l=2,m=2,r=1
        int actual = solution.findMin(nums);
        Assertions.assertEquals(1, actual);
    }

    /**
     * pivot < right < left => leftを探索すべき => right = pivot - 1;
     */
    @Test
    void example5() {
        Solution solution = new Solution();
        int[] nums = {5, 1, 2, 3, 4};
        int actual = solution.findMin(nums);
        Assertions.assertEquals(1, actual);
    }
}