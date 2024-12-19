package neetcode.arrays_and_hashing.top_k_frequents_elements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    @Test
    void test() {
        var solution = new Solution();
        int[] nums;
        int k;
        int[] result;
        nums = new int[]{1, 2, 2, 3, 3, 3};
        k = 2;
        result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result)); // [2, 3]
        nums = new int[]{7, 7};
        k = 1;
        result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result)); // [7]
    }
}
