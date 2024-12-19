package neetcode.arrays_and_hashing.valid_anagrams;

public class Solution {

    public boolean myIsAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }
        // System.out.println(map.toString());
        for (Character ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null || count == 0) {
                return false;
            }
            map.put(ch, count - 1);
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}

