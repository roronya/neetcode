package neetcode.backtracking.combination_sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return myCombinationSum(nums, target);
    }

    /**
     * targetを超えるまでnumsからどれかを使う
     */
    public List<List<Integer>> myCombinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Set<String> set = new HashSet<>();
        dfs(nums, target, combination, ans, set);
        return ans;
    }

    void dfs(int[] nums, int target, List<Integer> conbination, List<List<Integer>> ans, Set<String> set) {
        if (target == 0) {
            List<Integer> sorted = conbination.stream().sorted().toList();
            if (set.contains(sorted.toString())) {
                return;
            }
            ans.add(sorted);
            set.add(sorted.toString());
            return;
        }
        if (target < 0) return;
        for (int num : nums) {
            conbination.add(num);
            dfs(nums, target - num, conbination, ans, set);
            conbination.remove(conbination.size() - 1);
        }
    }
}
