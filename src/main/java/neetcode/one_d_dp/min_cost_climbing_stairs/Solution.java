package neetcode.one_d_dp.min_cost_climbing_stairs;

import java.util.Arrays;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return myMinCostClimbingStairs(cost);
    }

    /**
     * int[] dp = int[cost.length]を用意しておく
     * この中にはi階に行くための最小コストが格納される
     * すなわちdp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
     */
    public int myMinCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return 0;
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[cost.length];
    }
}