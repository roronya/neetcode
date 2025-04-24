package neetcode.one_d_dp.decode_ways;

class Solution {
    private int ans = 0;

    public int numDecodings(String s) {
        return myNumDecodings(s);
    }

    /**
     * オートマトンぽいな
     * 00 => NG
     * 01 => NG
     * 10 => NG
     * 11 => "AA" or "L"
     * <p>
     * 000 => NG
     * 001 => NG
     * 010 => NG
     * 011 => NG
     * 100 => NG
     * 101 => "LA"
     * 110 => "AL"
     * 111 => "AAA" or "LA" or "AL"
     * <p>
     * dp[i-1] = dp[i] + Xの形になるかな
     */
    public int myNumDecodings(String s) {
        return bottomUpDP(s);
        // dfs(s);
        // return ans;
    }

    private void dfs(String s) {
        if (s.isEmpty()) {
            ans++;
            return;
        }

        String subs = s.substring(0, 1);
        int num = Integer.parseInt(subs);
        if (num == 0) return;
        dfs(s.substring(1));

        if (s.length() < 2) return;
        subs = s.substring(0, 2);
        num = Integer.parseInt(subs);
        if (num > 26) return;
        dfs(s.substring(2));
    }

    private int bottomUpDP(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}

