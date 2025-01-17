package neetcode.sliding_window.minimum_window_substring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    public String minWindow(String s, String t) {
        return slidingWindow(s, t);
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

    // l,rをちょっとずつ狭めていく作戦
    String stack(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] tCount = new int[128];
        for (int i = 0; i < t.length(); i++) tCount[t.charAt(i)]++;
        System.out.println(Arrays.toString(tCount));

        // s[l,r]がtを含んでいるか確認
        // 含んでいなければcontinue
        // 含んでいればans = min(s[l:r], ans)してr--とl++をstackに積む
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{0, s.length() - 1});
        String ans = s;
        boolean found = false;
        HashSet<String> memo = new HashSet<>();
        while (!stack.isEmpty()) {
            System.out.println(stack.stream().map(Arrays::toString).toList());
            int[] lr = stack.pop();
            int l = lr[0], r = lr[1];
            String substring = s.substring(l, r + 1);
            if (memo.contains(substring)) continue;
            memo.add(substring);

            int[] sCount = new int[128];
            for (int i = 0; i < substring.length(); i++) sCount[substring.charAt(i)]++;

            boolean ok = true;
            for (int i = 0; i < 128; i++) {
                if (sCount[i] < tCount[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                found = true;
                if (r - l + 1 <= ans.length()) ans = substring;
                stack.push(new int[]{l + 1, r});
                stack.push(new int[]{l, r - 1});
            }
            System.out.println("-----------");
            System.out.println("substring = " + substring);
            System.out.println("ok = " + ok);
            System.out.println("ans = " + ans);
            System.out.println(Arrays.toString(sCount));
        }
        return found ? ans : "";
    }

    /**
     * rを全走査する
     * それぞれのrに対してlを必要なところまで縮める
     */
    String slidingWindow(String s, String t) {
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char ch : t.toCharArray()) tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);

        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0, need = tCount.size(), l = 0, ansL = 0, ansR = 0, ansLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (tCount.containsKey(ch) && tCount.get(ch).equals(window.get(ch))) have++;

            while (have == need) {
                // ansを更新
                if (r - l + 1 < ansLen) {
                    ansL = l;
                    ansR = r;
                    ansLen = Math.min(ansLen, r - l + 1);
                }

                // lに位置する文字をwindowから消す
                ch = s.charAt(l);
                window.put(ch, window.get(ch) - 1);
                if (tCount.containsKey(ch) && tCount.get(ch) > window.get(ch)) have--;
                l++;
            }
        }
        return ansLen == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR + 1);
    }

}
