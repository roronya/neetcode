package neetcode.sliding_window.minimum_window_substring;

import java.util.Arrays;

class Solution {
    public String minWindow(String s, String t) {
        return bruteForce(s, t);
    }

    // l,rの全部の組み合わせを列挙して、部分文字列を作りtを含むか確認する
    String bruteForce(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] tCount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }
        System.out.println(Arrays.toString(tCount));

        int l = 0, r = 0, minL = 0, minR = s.length() - 1;
        boolean match = false;
        for (l = 0; l < s.length(); l++) {
            for (r = l; r < s.length(); r++) {
                String subs = s.substring(l, r + 1);
                int[] subsCount = new int[128];
                for (int i = 0; i < subs.length(); i++) subsCount[subs.charAt(i)]++;

                int matches = 0;
                for (int i = 0; i < 128; i++) if (tCount[i] > 0 && subsCount[i] >= tCount[i]) matches += tCount[i];
                if (matches >= t.length() && r - l <= minR - minL) {
                    minL = l;
                    minR = r;
                    match = true;
                }
                System.out.println("------------");
                System.out.println("l:r = " + l + ":" + r);
                System.out.println("subs = " + subs);
                System.out.println("matches = " + matches);
                System.out.println("match = " + match);
                System.out.println("minL:minR = " + minL + ":" + minR);
                System.out.println(Arrays.toString(subsCount));
            }
        }
        return match ? s.substring(minL, minR + 1) : "";
    }

    // tを含むsの部分文字列を探す
    // まずrで舐めてtを含むr候補を見つけておく
    String mySolution(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] sCount = new int[128];
        int[] tCount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            sCount[s.charAt(i)]++;
            tCount[t.charAt(i)]++;
        }
        System.out.println("tCount\n" + Arrays.toString(tCount));

        // sのスライスの範囲を決めるポインタ
        int l = 0, r = t.length() - 1;

        // s[0:r]がtを含むまでrを増やす
        int matches = 0;
        while (matches < t.length()) {
            System.out.println("matches: " + matches);
            System.out.println("sCount\n" + Arrays.toString(sCount));

            sCount[s.charAt(r)]++;
            if (tCount[s.charAt(r)] > 0 && sCount[s.charAt(r)] >= tCount[s.charAt(r)]) matches++;
            r++;
            if (r >= s.length()) return ""; // 最後まで見てもtを含まない場合
        }
        System.out.println("l:r = " + l + ":" + r);
        System.out.println("rmax sCount\n" + Arrays.toString(sCount));

        // s[l:r]がtを含む文字列でいる限りlを増やす
        while (tCount[s.charAt(l)] < 1) {
            l++;
        }
        if (l > 0) l--; // ループ抜けたときtを含まなくなってるので1戻す

        //s[l:r]を返す
        return s.substring(l, r + 1);
    }

}
