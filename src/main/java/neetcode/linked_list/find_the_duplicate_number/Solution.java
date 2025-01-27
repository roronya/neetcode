package neetcode.linked_list.find_the_duplicate_number;

import java.util.HashSet;

class Solution {
    public int findDuplicate(int[] nums) {
        return negativeMarking(nums);
    }

    // O(n^2), O(1)
    int bruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return nums[i];
            }
        }
        return nums[0];
    }

    // O(n), O(n)
    int set(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) return n;
            set.add(n);
        }
        return 0;
    }

    // O(n), O(1)
    int negativeMarking(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) return Math.abs(nums[i]);
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
        return 0;
    }

}
