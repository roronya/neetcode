package neetcode.backtracking.n_queens;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<String>> res = new ArrayList<>();
    private char[][] board;
    /**
     * Qを置く場所を配列で持つ
     * 新しくQを置くたびに他のQの効きがないか確認し、問題なければ置く。問題あれば置かない。
     * 後片付けはQを持つ配列から最後尾を削除すれば良い。
     * n個おけたらboardを生成してresにいれる。
     *
     * boardを.#Qで更新していくやり方もあるが、元に戻す作業が大変。
     * Qを置く座標を持っておき、それらから計算で置ける/置けないの判断が出来た方が良い
     */

    private List<int[]> Qs = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        return mySolveNQueens(n);
    }

    public List<List<String>> mySolveNQueens(int n) {
        backtrack(0, n);
        return res;
    }

    private void backtrack(int r, int n) {
        if (r == n) {
            // Qsからboardを生成しresに突っ込む
            char[][] board = new char[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            for(int[] Q : Qs) {
                board[Q[0]][Q[1]] = 'Q';
            }
            List<String> part = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                String s = "";
                for(int j = 0; j < n; j++) {
                    s += board[i][j];
                }
                part.add(s);
            }
            res.add(part);
        }
        // (r, c)にQが置けるか
        // 置けないならcontinue
        // 置けるならQsに入れてbacktrack(r + 1, n)
        // その後Qsをもとに戻す
        for(int c = 0; c < n; c++) {
            if (!canPlace(r, c, n)) continue;
            Qs.add(new int[]{r, c});
            backtrack(r + 1, n);
            Qs.remove(Qs.size() - 1);
        }
    }

    private boolean canPlace(int r, int c, int n) {
        for(int[] Q : Qs) {
            // 横の確認
            if (r == Q[0]) return false;
            // 縦の確認
            if (c == Q[1]) return false;
            // 斜めの確認
            for(int i = 0; i < n; i++) {
                // 右斜め下
                if (Q[0] + i < n && Q[1] + i < n && r == Q[0] + i && c == Q[1] + i) return false;
                // 左斜め下
                if (Q[0] - i >= 0 && Q[1] + i < n && r == Q[0] - i && c == Q[1] + i) return false;
                // 左斜め上
                if (Q[0] - i >= 0 && Q[1] - i >= 0 && r == Q[0] - i && c == Q[1] - i) return false;
                // 右斜め上
                if (Q[0] + i < n && Q[1] - i >= 0 && r == Q[0] + i && c == Q[1] - i) return false;
            }
        }
        return true;
    }
}
