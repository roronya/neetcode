package neetcode.tries.word_seatch_ii;

import java.util.*;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        return myFindWords(board, words);
    }

    // 1文字目をboardから探す

    // そこから4方向へ探索していく
    // boolean[][]かSet<Pair<Integer, Integer>>で訪れた場所を記録しておき二度と訪れないようにする
    public List<String> myFindWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (search(board, word)) ans.add(word);
        }
        return ans;
    }

    boolean search(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, new int[]{i, j})) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int[] p) {
        boolean flag = false;
        Stack<int[]> stack = new Stack<>();
        stack.add(p);
        for (int c = 0; c < word.length(); c++) {
            Set<String> set = new HashSet<>();
            print(stack);
            System.out.println(set);
            char ch = word.charAt(c);
            Stack<int[]> newStack = new Stack<>();
            while (!stack.isEmpty()) {
                int[] top = stack.pop();
                int i = top[0], j = top[1];
                if (board[i][j] == ch) {
                    set.add(Arrays.toString(top));
                    int[][] d = {{i + 1, j}, {i, j + 1}, {i - 1, j}, {i, j - 1}};
                    for (int[] di : d) {
                        if (di[0] < 0 || di[1] < 0 || di[0] >= board.length || di[1] >= board[di[0]].length || set.contains(Arrays.toString(di)))
                            continue;
                        newStack.add(di);
                    }
                    if (c == word.length() - 1) flag = true;
                }
            }
            stack = newStack;
        }
        return flag;
    }

    void print(Collection<int[]> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int[] e : stack) {
            sb.append(Arrays.toString(e));
        }
        sb.append("]");
        System.out.println(sb);
    }

}
