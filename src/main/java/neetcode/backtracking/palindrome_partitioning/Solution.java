package neetcode.backtracking.palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<List<String>> res = new ArrayList<>();
    private final List<String> part = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, s);
        return res;
    }

    private void dfs(int start, String s) {
        System.out.println("----------------");
        System.out.println(res);
        System.out.println(part);
        if (start == s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPali(s, start, end)) {
                part.add(s.substring(start, end + 1));
                dfs(end + 1, s);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}

