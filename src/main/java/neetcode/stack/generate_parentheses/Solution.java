package neetcode.stack.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        // return bluteForceGenerateParenthesis(n);
        return backtrackingGenerateParenthesis(n);
    }

    List<String> backtrackingGenerateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }

    void backtrack(int open, int close, int n, List<String> res, StringBuilder stack) {
        if (open == close && open == n) {
            res.add(stack.toString());
            return;
        }
        if (open < n) {
            stack.append('(');
            backtrack(open + 1, close, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (close < open) {
            stack.append(')');
            backtrack(open, close + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    /**
     * 全通りの組み合わせを生成して、それらが正しいカッコの組み合わせになっているかを検証する
     * nはカッコの数なので文字列として展開すると()となるため2n
     * したがって組み合わせのパターンは高々2^2*nとなる。n<=7のため2^14=約16000通り
     * またisValidがnかかる
     * time complexity:  O(2^2n * n)
     * space complexity: O(2^2n * n)
     */
    List<String> bluteForceGenerateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", res, n);
        System.out.println(res);
        return res;
    }

    void dfs(String s, List<String> res, int n) {
        if (s.length() == n * 2) {
            if (isValid(s)) res.add(s);
            return;
        }
        dfs(s + '(', res, n);
        dfs(s + ')', res, n);
    }

    boolean isValid(String s) {
        int c = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(') c++;
            else c--;
            if (c < 0) return false;
        }
        return c == 0;
    }
}
