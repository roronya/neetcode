package neetcode.two_pointers.two_integer_sum_ii;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return myTwoSum(numbers, target);
    }

    /**
     * ソート済みであることを利用してO(n)の探索で済む
     */
    public int[] myTwoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (true) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) break;
            if (sum > target) r--;
            else l++;
        }
        return new int[]{l + 1, r + 1};
    }
}
