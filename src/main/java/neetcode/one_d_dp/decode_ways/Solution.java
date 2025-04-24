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
        backtrack(s);
        return ans;
    }

    private void backtrack(String s) {
        if (s.isEmpty()) {
            ans++;
            return;
        }

        String subs = s.substring(0, 1);
        int num = Integer.parseInt(subs);
        if (num == 0) {
            return;
        }
        backtrack(s.substring(1));

        if (s.length() < 2) return;
        subs = s.substring(0, 2);
        num = Integer.parseInt(subs);
        if (num > 26) return;
        backtrack(s.substring(2));
    }
}

