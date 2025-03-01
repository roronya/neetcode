package neetcode.binary_search.median_of_two_sorted_arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        Solution solution = new Solution();
        int[] nums1 = {1, 2}, nums2 = {3};
        double actual = solution.findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(2.0, actual);
    }

    @Test
    void example2() {
        Solution solution = new Solution();
        int[] nums1 = {1, 3}, nums2 = {2, 4};
        double actual = solution.findMedianSortedArrays(nums1, nums2);
        Assertions.assertEquals(2.5, actual);
    }
}