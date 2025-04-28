package neetcode.coin_change;

import java.util.Arrays;

class Solution {
    private int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        return bottomUpDp(coins, amount);
        // return myCoinChange(coins, amount);
    }

    /**
     * dfsで解けそう
     */
    public int myCoinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        dfs(0, coins, amount);
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    private boolean dfs(int count, int[] coins, int amount) {
        if (amount < 0) return false;
        if (amount == 0) return true;

        for (int c : coins) {
            if (dfs(count + 1, coins, amount - c)) {
                ans = Math.min(ans, count + 1);
            }
        }
        return false;
    }

    /**
     * int[] dpは残りamountでアクセスすると最小のcountを教えてくれる。
     * dp[0] = 0 で初期化し、dp[1~amount]までcoinを足していく。
     * 1ループ目
     * coinを順番に舐めて、1以下であればそのコインを使う。いまcoinに1があったとすると
     * dp[1] = dp[0] + 1 となり、1枚のコインを使ったことになる。
     * <p>
     * nループ目
     * coinがn以下であればそのコインを使う
     * dp[n] = Math.min(dp[n], dp[n - coin[j]] + 1)で更新する。
     * いま現在の値よりも、coin[j]を使って1枚消費しただけのほうが、全体的にコインを少なくおさえられるのか確認している。
     */
    public int bottomUpDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
