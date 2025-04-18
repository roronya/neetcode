package neetcode.one_d_dp.house_robber;

class Solution {
    public int rob(int[] nums) {
        return myRob(nums);
    }

    /**
     * 隣り合ってはいけないから、最大を取るには偶数要素か奇数要素か
     * 2つ飛ばして偶数→奇数→...、奇数→偶数→...のような取り方をする
     * したがってdp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i]でいいかも
     * [1,2,3,4,5]とあったとき組み合わせとしては
     * 1: [1,3,5] (偶数要素のみ
     * 2: [2,4] (奇数要素のみ
     * 3: [1,4] (偶数→奇数
     * 4: [2,5] (奇数→偶数
     */
    public int myRob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];
        for(int i = 3; i< nums.length; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
