package neetcode.arrays_and_hashing.group_anagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagrams2(strs);
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] a = new int[26];
            for (int i = 0; i < str.length(); i++) a[str.charAt(i) - 'a']++;
            String k = Arrays.toString(a);
            if (!map.containsKey(k)) map.put(k, new ArrayList<>());
            map.get(k).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }


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
    public List<List<String>> optimalGroupAnagrams(String[] strs) {
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
