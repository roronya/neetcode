package neetcode.sliding_window.longest_repeating_character_replacement;

class Solution {
    public int characterReplacement(String s, int k) {
        return bruteForce(s, k);
    }

    int bruteForce(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char prev = s.charAt(i);
            int j = i + i;
            int l = k;
            while (j < s.length()) {
                if (s.charAt(j) != prev + 1) {
                    if (l == 0) break;
                    l--;
                }
                prev = (char) (prev + 1);
                j++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
