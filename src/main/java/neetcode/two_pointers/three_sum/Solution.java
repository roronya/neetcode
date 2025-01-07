package neetcode.two_pointers.three_sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                if (sum > 0) r--;
                else l++;
            }
        }
        return set.stream().toList();
    }
}
