package neetcode.sliding_window.sliding_window_maximum;

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return dequeue(nums, k);
    }

    // brute force
    // time complexity O(n*k)
    int[] bruteForce(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans.add(max);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    // sliding window
    // 一度並び替えれば、あとはスライドしていったときに消す・増える要素の削除と挿入のみ？
    // 最初のソート O(nlogn)
    // 消すときと挿入時は 要素の探索のみなのでO(nlogn)でいけそう
    // O(k * nlogn)でいけそうだが、brute forceのほうがはやい？
    int[] slidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k - 1; i++) q.add(nums[i]);
        for (int l = 0, r = k - 1; r < nums.length; l++, r++) {
            q.add(nums[r]);
            System.out.println(q);
            ans.add(q.peek());
            q.remove(nums[l]);
        }
        System.out.println(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    // dequeue
    // monotonic decreasing dequeueを作る。各windowで常に左から取ればmaxが取れるようにする。
    int[] dequeue(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;

        while (r < n) {
            // rより小さい値は後ろから消しておく
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            // windowがスライドしたときに範囲外になったら最大値を消す(いちばん頭のこと)
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            // rがkより大きくなるまで単に上の処理を繰り返す
            // kより大きくなったらスライドを開始する
            // outputのindexはlに等しい
            if ((r + 1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}
