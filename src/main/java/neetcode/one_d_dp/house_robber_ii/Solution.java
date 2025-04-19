package neetcode.one_d_dp.house_robber_ii;

import java.util.Arrays;

class Solution {
    int[] dp;

    public int rob(int[] nums) {
        return optimalRob(nums);
    }

    public int optimalRob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(
                helper(Arrays.copyOfRange(nums, 1, nums.length)),
                helper(Arrays.copyOfRange(nums, 0, nums.length - 1))
        );
    }

    private int helper(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]); // ?

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }

    /**
     * 0から始める場合はnums[0:nums.length-1]
     * 1から始める場合はnums[1:nums.length]
     * でdpすれば良い
     */
    public int myRob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        bottomUpDp(nums, 0, nums.length - 1);
        bottomUpDp(nums, 1, nums.length);
        return Math.max(nums[nums.length - 2], nums[nums.length - 1]);
    }

    private void bottomUpDp(int[] nums, int from, int to) {
        for (int i = from; i < to; i++) {
            if (i < 2) continue;
            nums[i] = Math.max(nums[i - 3], nums[i - 2]);
        }
    }
}
