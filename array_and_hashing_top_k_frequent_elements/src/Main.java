import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    var solution = new Solution();
    int[] nums;
    int k;
    int[] result;
    nums = new int[]{1, 2, 2, 3, 3, 3};
    k = 2;
    result = solution.topKFrequent(nums, k);
    System.out.println(Arrays.toString(result)); // [2, 3]
    nums = new int[]{7, 7};
    k = 1;
    result = solution.topKFrequent(nums, k);
    System.out.println(Arrays.toString(result)); // [7]
  }
}
