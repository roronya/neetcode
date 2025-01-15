package neetcode.sliding_window.permutation_in_string;

import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        return bruteForce(s1, s2);
    }

    boolean bruteForce(String s1, String s2) {
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char ch : s1.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);

            for (int j = 0; j < s1.length(); j++) {
                char ch = s2.charAt(i + j);
                if (!map.containsKey(ch)) break;
                if (map.get(ch) - 1 < 1) map.remove(ch);
                else map.put(ch, map.get(ch) - 1);
            }
            if (map.isEmpty()) return true;
        }
        return false;
    }
}
