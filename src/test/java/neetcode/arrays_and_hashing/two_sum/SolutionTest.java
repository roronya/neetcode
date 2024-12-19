package neetcode.arrays_and_hashing.two_sum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    @Test
    void test() {
        Solution solution = new Solution();
        int[] nums1 = {3, 4, 5, 6};
        int target1 = 7;
        var result = solution.twoSum(nums1, target1);
        System.out.println(Arrays.toString(result)); // [0,1]
        int[] nums2 = {4, 5, 6};
        int target2 = 10;
        result = solution.twoSum(nums2, target2);
        System.out.println(Arrays.toString(result)); // [0,2]
        int[] nums3 = {5, 5};
        int target3 = 10;
        result = solution.twoSum(nums3, target3);
        System.out.println(Arrays.toString(result)); // [0,1]
    }
}