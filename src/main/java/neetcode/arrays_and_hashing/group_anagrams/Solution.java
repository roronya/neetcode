package neetcode.arrays_and_hashing.group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    /**
     * m is number of strings and n is length of the longest string
     * Time complexity: O(m * nlogn) // containsKey is nlogn
     * Space complexity: O(m * n)
     */
    public List<List<String>> mygroupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            var chars = str.toCharArray();
            Arrays.sort(chars);
            var key = new String(chars);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());
    }

    /**
     * m is number of strings and n is length of the longest string
     * Time complexity: O(n)
     * Space complexity: O(m * n)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            var count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        }
        return new ArrayList<>(result.values());
    }
}
