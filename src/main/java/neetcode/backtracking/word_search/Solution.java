package neetcode.backtracking.word_search;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean res = dfs(0, i, j, new HashSet<>(), board, word);
                if (res) return true;
            }
        }
        return false;
    }

    private boolean dfs(int wi, int i, int j, Set<String> path, char[][] board, String word) {
        if (wi == word.length()) return true;
        if (word.charAt(wi) != board[i][j]) return false;
        int[][] d = {{i + 1, j}, {i, j + 1}, {i - 1, j}, {i, j - 1}};
        path.add(i + ":" + j);
        for (int[] di : d) {
            if (di[0] < 0 || di[1] < 0 || di[0] >= board.length || di[1] >= board[di[0]].length || path.contains(di[0] + ":" + di[1]))
                continue;
            if (dfs(wi + 1, di[0], di[1], path, board, word)) return true;
        }
        path.remove(i + ":" + j);
        return false;
    }
}
