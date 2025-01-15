package neetcode.sliding_window.permutation_in_string;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        return slidingWindow(s1, s2);
    }

    boolean slidingWindow(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(s1Count));
        for (int l = 0, r = s1.length() - 1; r < s2.length(); l++, r++) {
            if (l > 0) {
                s2Count[s2.charAt(l - 1) - 'a']--;
                s2Count[s2.charAt(r) - 'a']++;
            }
            System.out.println(Arrays.toString(s2Count));
            int matches = 0;
            for (int i = 0; i < 26; i++) {
                if (s1Count[i] == s2Count[i]) matches++;
            }
            System.out.println(matches);
            if (matches == 26) return true;
        }
        return false;
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
