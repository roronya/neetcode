package neetcode.backtracking.word_search;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
                board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }

        board[r][c] = '#';
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                dfs(board, word, r - 1, c, i + 1) ||
                dfs(board, word, r, c + 1, i + 1) ||
                dfs(board, word, r, c - 1, i + 1);
        board[r][c] = word.charAt(i);
        return res;
    }

    public boolean myExist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean res = myDfs(0, i, j, new HashSet<>(), board, word);
                if (res) return true;
            }
        }
        return false;
    }

    private boolean myDfs(int wi, int i, int j, Set<String> path, char[][] board, String word) {
        if (wi == word.length()) return true;
        if (word.charAt(wi) != board[i][j]) return false;
        int[][] d = {{i + 1, j}, {i, j + 1}, {i - 1, j}, {i, j - 1}};
        path.add(i + ":" + j);
        for (int[] di : d) {
            if (di[0] < 0 || di[1] < 0 || di[0] >= board.length || di[1] >= board[di[0]].length || path.contains(di[0] + ":" + di[1]))
                continue;
            if (myDfs(wi + 1, di[0], di[1], path, board, word)) return true;
        }
        path.remove(i + ":" + j);
        return false;
    }
}
