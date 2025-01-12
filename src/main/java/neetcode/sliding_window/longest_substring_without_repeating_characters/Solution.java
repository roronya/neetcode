package neetcode.sliding_window.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        return onePass(s);
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

    // time complexity: O(n)
    // space complexity: O(m)
    int onePass(String s) {
        if (s.isEmpty()) return 0;
        int l = 0, r = 1, ans = 0;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(l));
        while (l < s.length() && r < s.length()) {
            if (set.contains(s.charAt(r))) {
                ans = Math.max(ans, r - l);
                set = new HashSet<>();
                l++;
                r = l;
            }
            set.add(s.charAt(r));
            r++;
        }
        return Math.max(ans, r - l);
    }

    public int optimal(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            if (mp.containsKey(s.charAt(r))) {
                l = Math.max(mp.get(s.charAt(r)) + 1, l);
            }
            mp.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
