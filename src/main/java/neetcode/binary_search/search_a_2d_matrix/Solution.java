package neetcode.binary_search.search_a_2d_matrix;

import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left <= right) {
            int pivot = (left + right) / 2;
            int[] array = matrix[pivot];
            if (array[0] <= target && target <= array[array.length - 1]) return searchArray(array, target);
            else if (target < array[0]) right = pivot - 1;
            else left = pivot + 1;
        }
        return false;
    }

    boolean searchArray(int[] array, int target) {
        System.out.println(Arrays.toString(array));
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int pivot = (left + right) / 2;
            System.out.println(array[pivot]);
            if (array[pivot] == target) return true;
            if (target < array[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return false;
    }
}

