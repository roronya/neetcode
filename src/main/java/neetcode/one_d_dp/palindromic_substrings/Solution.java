package neetcode.one_d_dp.palindromic_substrings;

class Solution {
    public int countSubstrings(String s) {
        return myCountSubstrings(s);
    }

    /**
     * (l,r) = (5,5), (4,4), (4,5), (3,3), (3,4), (3,5), ...
     * で探索して、palindromicなsubstringを見つけたらcount++
     */
    public int myCountSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int l = n - 1; l >= 0; l--) {
            for(int r = l; r < n; r++) {
                // System.out.println(l + ":" + r);
                if ((r - l == 0)
                        || (r - l == 1 && (dp[l+1][r-1] || dp[l+1][r]) && s.charAt(l) == s.charAt(r))
                        || (dp[l+1][r-1] && s.charAt(l) == s.charAt(r))) {
                    ans++;
                    dp[l][r] = true;
                }
            }
        }
        for(boolean[] r : dp ) {
            for(boolean e : r) {
                System.out.print(e + ",");
            }
            System.out.println();
        }
        return ans;
    }
}
