package neetcode.arrays_and_hashing.products_of_array_except_self;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    @Test
    void test() {
        Solution solution = new Solution();
        int[] nums, res;

        nums = new int[]{1, 2, 4, 6};
        res = solution.productExceptSelf(nums); // [48,24,12,8]
        System.out.println(Arrays.toString(res));
        nums = new int[]{-1, 0, 1, 2, 3};
        res = solution.productExceptSelf(nums); // [0,-6,0,0,0]
        System.out.println(Arrays.toString(res));
    }

}
