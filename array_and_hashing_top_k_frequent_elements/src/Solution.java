import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    return topKFrequentSort(nums ,k);
  }

  // time complexity: O(n log n)
  // space complexity: O(n)
  public int[] topKFrequentSort(int[] nums, int k) {
    // input: [1, 2, 2, 2, 3, 3]
    // to: {1:1, 2:3, 3:2}
    HashMap<Integer, Integer> count = new HashMap<>();
    for (int num: nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    // to: [[2,3], [3,2], [1,1]]
    // notice!: key and value are replaced like [value, key]
    List<int[]> arr = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
      arr.add(new int[] {entry.getValue(), entry.getKey()});
    }
    // to: [[3,2], [2,3], [1,1]]
    arr.sort((a, b) -> b[0] - a[0]);

    // to: [3,2]
    int[] res = new int[k];
    for (int i=0;i<k;i++) {
      res[i] = arr.get(i)[1];
    }
    return res;
  }

  // time complex: O(n log k)
  // space complex: O(n + k)
  public int[] topKFrequentHeap(int[] nums, int k) {
    // in: [1,2,2,2,3,3]
    // to: {1:1,2:3,3:2}
    HashMap<Integer, Integer> count = new HashMap<>();
    for(int num: nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    // to: {2:3, 3:2}
    PriorityQueue<int[]> heap = new PriorityQueue<>((a ,b) -> a[0] - b[0]);
    for(Map.Entry<Integer, Integer> entry: count.entrySet()) {
      heap.offer(new int[]{entry.getValue(), entry.getKey()});
      if (heap.size() > k) heap.poll();
    }

    int[] res = new int[k];
    for (int i=0;i<k;i++) res[i] = heap.poll()[1];

    return res;
  }
}
