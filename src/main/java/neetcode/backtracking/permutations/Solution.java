package neetcode.backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        return bruteforce(nums);
    }

    public List<List<Integer>> bruteforce(int[] nums) {
        ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i == j || i == k || k == j) continue;
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                }
            }
        }
        return ans;
    }
}
