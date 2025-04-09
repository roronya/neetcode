package neetcode.backtracking.combination_sum_ii;


import java.util.*;

class Solution {
    List<List<Integer>> ans;
    Set<String> set;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return myCombinationSum2(candidates, target);
    }

    public List<List<Integer>> myCombinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        set = new HashSet<>();
        myDfs(0, new ArrayList<>(), 0, candidates, target);
        return ans;
    }

    private void myDfs(int i, List<Integer> cur, int total, int[] candidates, int target) {
        if (total == target && !set.contains(cur.toString())) {
            ans.add(new ArrayList<>(cur));
            set.add(cur.toString());
        }
        for (int j = i; j < candidates.length; j++) {
            if (total + candidates[j] > target) return;
            cur.add(candidates[j]);
            myDfs(j + 1, cur, total + candidates[j], candidates, target);
            cur.remove(cur.size() - 1);
        }
    }
}

