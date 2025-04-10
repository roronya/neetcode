package neetcode.backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        return myPermute(nums);
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

    public List<List<Integer>> myPermute(int[] nums) {
        ans = new ArrayList<>();
        //dfs(nums, new ArrayList<>());
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    // time complexity: O(n * n)
    // space complexity: O(n)
    private void dfs(int[] nums, List<Integer> cur) {
        if (nums.length == cur.size()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int num : nums) {
            if (cur.contains(num)) continue;
            cur.add(num);
            dfs(nums, cur);
            cur.remove(cur.size() - 1);
        }
    }

    // time complexity: O(n)
    // space complexity: O(n)
    private void backtrack(List<Integer> perm, int[] nums, boolean[] pick) {
        if (perm.size() == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;
                backtrack(perm, nums, pick);
                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }
    }

}
