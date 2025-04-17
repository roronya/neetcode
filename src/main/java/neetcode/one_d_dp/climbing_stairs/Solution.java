package neetcode.one_d_dp.climbing_stairs;

class Solution {
    private int ans;

    public int climbStairs(int n) {
        return myClimbStairs(n);
    }

    /**
     * 1 or 2
     * backtrackで良さそう
     * その後メモ化する
     */
    public int myClimbStairs(int n) {
        search(0, n);
        return ans;
    }

    private void search(int i, int n) {
        if (i == n) {
            ans++;
            return;
        } else if (i > n) {
            return;
        }
        search(i + 1, n);
        search(i + 2, n);
    }
}
