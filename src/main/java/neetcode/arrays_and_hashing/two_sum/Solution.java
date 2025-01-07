package neetcode.arrays_and_hashing.two_sum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        return twoSum2(nums, target);
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value:index
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public int[] twoSum_n2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSum_twoPath(int[] nums, int target) {
        var map = new java.util.HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            var j = map.get(target - nums[i]);
            if (j != null && i != j) return new int[]{i, j};
        }
        return new int[0];
    }

    public int[] myTwoSum(int[] nums, int target) {
        var map = new java.util.HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var diff = target - nums[i];
            var j = map.get((Integer) diff);
            if (j != null) return new int[]{j, i};
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
