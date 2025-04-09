package neetcode.backtracking.combination_sum;

import java.util.*;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        return optimal(nums, target);
    }

    public List<List<Integer>> optimal(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums); // sortしておくことで、探索順序が小さいやつをたくさん使う順になるので妥当

        dfs(0, new ArrayList<>(), 0, nums, target);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }
            cur.add(nums[j]);
            dfs(j, cur, total + nums[j], nums, target);
            cur.remove(cur.size() - 1);
        }
    }


    /**
     * targetを超えるまでnumsからどれかを使う
     */
    public List<List<Integer>> myCombinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Set<String> set = new HashSet<>();
        myDfs(nums, target, combination, ans, set);
        return ans;
    }

    void myDfs(int[] nums, int target, List<Integer> conbination, List<List<Integer>> ans, Set<String> set) {
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
            myDfs(nums, target - num, conbination, ans, set);
            conbination.remove(conbination.size() - 1);
        }
    }
}
