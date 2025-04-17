package neetcode.one_d_dp.climbing_stairs;

class Solution {
    private int ans;

    private int[] cache;
    private int dp(int n) {
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
     */
    int dfs(int n, int i) {
        if (i >= n) return i == n ? 1 : 0;
        if (cache[i] != -1) return cache[i];
        return cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }

    public int climbStairs(int n) {
        return dp(n);
        // return myClimbStairs(n);
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
}
