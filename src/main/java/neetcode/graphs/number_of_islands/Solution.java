package neetcode.graphs.number_of_islands;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    /**
     * gridを舐めていく
     * 1だったらcountを++
     * 探索で上下左右を確認し、1だったら-1に変えていく、両方とも0だったら探索を辞めて分岐に戻る
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.println("----------------");
                System.out.println("(" + i + "," + j + ") = " + grid[i][j]);
                System.out.println("----------------");
                if (grid[i][j] != '1') continue;
                count++;
                grid[i][j] = '2';
                Stack<int[]> stack = new Stack<>();
                stack.add(new int[]{i + 1, j});
                stack.add(new int[]{i - 1, j});
                stack.add(new int[]{i, j + 1});
                stack.add(new int[]{i, j - 1});
                System.out.println("into while");
                while (!stack.isEmpty()) {
                    int[] xy = stack.pop();
                    int x = xy[0];
                    int y = xy[1];
                    System.out.println(Arrays.toString(xy));
                    if (!(0 <= x && x < grid.length && 0 <= y && y < grid[0].length)) continue;
                    if (grid[x][y] == '0' || grid[x][y] == '2') continue;
                    grid[x][y] = '2';
                    stack.add(new int[]{x + 1, y});
                    stack.add(new int[]{x - 1, y});
                    stack.add(new int[]{x, y + 1});
                    stack.add(new int[]{x, y - 1});
                }
            }
        }
        return count;
    }
}
