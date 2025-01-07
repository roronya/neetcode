package neetcode.stack.largest_rectangle_in_histogram;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        return stack(heights);
    }

    /**
     * [7, 1, 7, 2, 2, 4]
     * [(7, 1), (1, 6), (7, 1), (2, 4), ...
     * [7, 6, 7, 8, 8, 4]
     * 縦は自分自身だから、横の計算が問題で、自分より小さい値が出てきた時点で終わり
     * time complexity: n * n = O(n^2)
     * space complexity: O(1)
     */
    int bruteForce(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int w = 1;
            for (int j = i - 1; j >= 0 && heights[j] >= heights[i]; j--) w++;
            for (int j = i + 1; j < heights.length && heights[j] >= heights[i]; j++) w++;
            max = Math.max(max, h * w);
        }
        return max;
    }

    /**
     * 高さがどこから続くのかをstackで管理する
     * 減ったタイミングでその高さは終わり
     * [7, 1, 7, 2, 2, 4]
     * 7→1のタイミングで7はもう拡張できない
     * [(0, 7)] => max = 7
     * 7→2
     * [(0, 1), (2, 7)] => max = 7
     * [(0, 1), (2, 2), (4, 2), (5, 4)]
     * 4, 4, 8, 6
     * <p>
     * int[] heights = new int[]{2, 1, 5, 6, 2, 3};
     * [(0, 2)] => 2
     * [(0, 1), (2, 5), (3, 6)]
     * [(0, 1), (
     */
    int stack(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                maxArea = Math.max(maxArea, (i - top[0]) * top[1]);
                index = top[0];
            }
            stack.push(new int[]{index, heights[i]});
        }
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - top[0]) * top[1]);
        }
        return maxArea;
    }

}
