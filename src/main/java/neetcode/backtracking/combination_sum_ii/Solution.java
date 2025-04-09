package neetcode.backtracking.combination_sum_ii;


import java.util.*;

class Solution {
    List<List<Integer>> ans;
    Set<String> set;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //return myCombinationSum2(candidates, target);
        return optimal(candidates, target);
    }

    public List<List<Integer>> optimal(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), 0, candidates, target);
        return ans;
    }

    private void dfs(int idx, List<Integer> path, int cur, int[] candidates, int target) {
        System.out.println(path);
        if (cur == target) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = idx; i < candidates.length; i++) {
            // candidateが[1,2,2,3]のとき
            // [1,2,3]の組み合わせが2つできてしまうのを避けたいので、被ってる数字はスキップする
            // i <= idxのとき最初の数字を選ぶときで、このときはすでにpathに同じ数字が入っていることは認識していないので
            // [2,2]の組み合わせを作ることはできる
            if (i > idx && candidates[i] == candidates[i - 1]) {
                //
                continue;
            }
            if (cur + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            dfs(i + 1, path, cur + candidates[i], candidates, target);
            path.remove(path.size() - 1);
        }
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

