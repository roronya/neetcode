public class Solution {
    public int[] twoSum_n2(int[] nums, int target) {
        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSum_twoPath(int[] nums, int target) {
        var map = new java.util.HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }
        for (int i=0;i<nums.length;i++) {
            var j = map.get(target-nums[i]);
            if (j != null && i != j) return new int[]{i, j};
        }
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target) {
        var map = new java.util.HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++) {
            var diff = target - nums[i];
            var j = map.get((Integer)diff);
            if (j != null) return new int[] {j, i};
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
