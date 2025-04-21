package neetcode.one_d_dp.longest_palindromic_substring;

class Solution {
    /**
     * Input: s = "ababd"
     * iは後ろから前へ
     * jはiから後ろへ
     * もしs[i]とs[j]が等しく、dp[i+1][j-1]がtrueならdp[i][j]はtrue
     * dp[i][j]はs[i..j]が回文という意味
     * dp[i+1][j-1]がtrueでs[i]==s[j]なら、すでに回文だとわかっているところの枠が両脇に増えたということ。
     */
    public String longestPalindrome(String s) {
        int resIdx = 0, resLen = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j - 1])) {
                    dp[i][j] = true;
                    if(resLen < (j - i + 1)) {
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        }
        return s.substring(resIdx, resIdx + resLen);
    }
}
