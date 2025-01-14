package neetcode.sliding_window.longest_repeating_character_replacement;

import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        return optimal(s, k);
    }

    public int optimal(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>(); // char:frequency
        int res = 0;

        int l = 0, maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r))); // 常に最大頻度値を保持する

            // 今の長さから最大頻度値を引くと置き換える必要のある数がわかる
            // 置き換える必要のある数がkより多いとき左のポインタをインクリメントし、
            // 左ポインタに位置する文字の頻度値をデクリメントする
            while ((r - l + 1) - maxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
