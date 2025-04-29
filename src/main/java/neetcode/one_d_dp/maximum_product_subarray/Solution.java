package neetcode.one_d_dp.maximum_product_subarray;

class Solution {
    public int maxProduct(int[] nums) {
        return bruteforce(nums);
    }

    public int bruteforce(int[] nums) {
        if (nums.length == 0) return 0;
        int res = nums[0];
        for(int i = 0; i < nums.length; i++) {
            int product = nums[i];
            res = Math.max(res, product);
            for(int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                res = Math.max(res, product);
            }
        }
        return res;
    }
}
