package neetcode.arrays_and_hashing.valid_sudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    /**
     * Sudoku rule
     * 1. Each row must contain the digits 1-9 without duplicates.
     * 2. Each column must contain the digits 1-9 without duplicates.
     * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
     */
    public boolean isValidSudoku(char[][] board) {
        return onepassIsValidSudoku(board);
    }

    public boolean onepassIsValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> blocks = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                String blockKey = i / 3 + "," + j / 3;
                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) ||
                        cols.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
                        blocks.computeIfAbsent(blockKey, k -> new HashSet<>()).contains(board[i][j])) {
                    return false;
                }
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                blocks.get(blockKey).add(board[i][j]);
            }
        }
        return true;
    }

    public boolean myIsValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> columnSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // rule1
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    } else {
                        rowSet.add(board[i][j]);
                    }
                }

                // rule2
                if (board[j][i] != '.') {
                    if (columnSet.contains(board[j][i])) {
                        return false;
                    } else {
                        columnSet.add(board[j][i]);
                    }
                }
            }
        }

        // rule3
        // 各ブロックの左上の座標を起点に3*3を探索すれば良い
        // iが縦、jが横として以下が起点
        int[][] blocks = {
                {0, 0}, {0, 3}, {0, 6},
                {3, 0}, {3, 3}, {3, 6},
                {6, 0}, {6, 3}, {6, 6},
        };
        for (int[] block : blocks) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int s = block[0] + i;
                    int t = block[1] + j;
                    if (board[s][t] != '.') {
                        if (set.contains(board[s][t])) {
                            return false;
                        } else {
                            set.add(board[s][t]);
                        }
                    }
                }
            }
        }

        return true;
    }
}

