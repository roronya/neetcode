package neetcode.sliding_window.longest_substring_without_repeating_characters;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        return bruteForce(s);
    }

    int bruteForce(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    ans = Math.max(ans, count);
                    break;
                }
                count++;
                set.add(s.charAt(j));
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
