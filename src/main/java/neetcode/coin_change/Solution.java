package neetcode.coin_change;

class Solution {
    private int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        return myCoinChange(coins, amount);
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
}

