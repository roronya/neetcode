package neetcode.one_d_dp.word_break;

import java.util.List;

class Solution {
    private boolean isMatch(String s, String word) {
        if (s.length() < word.length()) return false;
        for (int i = 0; i < word.length(); i++) {
            if (s.charAt(i) != word.charAt(i)) return false;
        }
        return true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return bruteforce(s, wordDict);

    }

    private boolean bruteforce(String s, List<String> wordDict) {
        //System.out.println("-------------");
        //System.out.println(s);
        /**
         * sの先頭数文字がwordDictに含まれているか確認する。
         * 一致したらその分だけ引いて、残りの文字列が再度wordDictに含まれているか確認する。
         */
        for (String word : wordDict) {
            System.out.println(s + ":" + word);
            // 各wordに対して先頭数文字と一致するか確認
            // 一致した場合はその文字列を差っ引いて、再度wordBreakする。
            // 再起したwordBreakの結果がだめだったら別のwordを試す。
            if (isMatch(s, word)) {
                // 文字列長が一緒なら探索終わり
                if (s.length() == word.length()) {
                    return true;
                }
                String newS = s.substring(word.length());
                if (wordBreak(newS, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
}

