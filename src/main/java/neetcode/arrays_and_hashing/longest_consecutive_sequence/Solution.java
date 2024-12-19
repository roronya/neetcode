package neetcode.arrays_and_hashing.longest_consecutive_sequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        return myLongestConsecutive(nums);
    }

    /**
     * 1ループ目
     * ・すべてSetに入れておく
     * 2ループ目
     * ・シーケンスの開始候補を見つける
     * ・自分-1の値が集合にないものが候補
     * 3ループ目
     * ・シーケンスの開始候補をインクリメントしていき集合の中に入っているか確認する
     * ・入っていればcount++。集合から取れなくなるまで繰り返す
     */
    public int myLongestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> candidates = new ArrayList<>();
        for (int num : nums) {
            if (!set.contains(num - 1)) candidates.add(num);
        }

        int res = 0;
        for (Integer candidate : candidates) {
            int consecutive = candidate;
            int count = 0;
            while (set.contains(consecutive)) {
                consecutive++;
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

}
