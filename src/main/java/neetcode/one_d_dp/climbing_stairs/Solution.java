package neetcode.one_d_dp.climbing_stairs;

class Solution {
    private int ans;

    private int[] cache;

    public int climbStairs(int n) {
        return bottomUpDp(n);
        // return topdownDp(n);
        // return myClimbStairs(n);
    }

    private int topdownDp(int n) {
        cache = new int[n];
        for(int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0);
    }

    /**
     * n = 10
     * i = 9まできたらあとは1を1回足すしかない => 1
     * i = 8は1を2回か2を1回 1を1回足した時点であと1だということは↑からわかる
     * i = 7のとき1を3回 2を1回1を1回 i=8まで行った時点で2だということはわかる
     * cache = {7: ...,8: 2, 9:1}
     */
    int dfs(int n, int i) {
        if (i >= n) return i == n ? 1 : 0;
        if (cache[i] != -1) return cache[i];
        return cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }

    /**
     * 1 or 2
     * backtrackで良さそう
     * その後メモ化する
     */
    public int myClimbStairs(int n) {
        bruteforce(0, n);
        return ans;
    }

    private void bruteforce(int i, int n) {
        if (i == n) {
            ans++;
            return;
        } else if (i > n) {
            return;
        }
        bruteforce(i + 1, n);
        bruteforce(i + 2, n);
    }

    public int bottomUpDp(int n) {
        // 1のとき return 1
        // 2のとき return 2(1+1 or 2)
        // なのでそのままnを返せば良い
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        // 3以降は過去の組み合わせから出来上がるという構造
        // 3は1個前に1を足すのと2個前に2を足すの2通りの作り方がある。
        // つまり1個前を作るパターンと2個前を作るパターンの数を足し合わせれば良い。（？）
        // 2を足すのでは？否、パターンが増えているわけではない。
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
