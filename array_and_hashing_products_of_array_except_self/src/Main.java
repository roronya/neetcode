import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums, res;

    nums = new int[]{1,2,4,6};
    res = solution.productExceptSelf(nums); // [48,24,12,8]
    System.out.println(Arrays.toString(res));
    nums = new int[]{-1,0,1,2,3};
    res = solution.productExceptSelf(nums); // [0,-6,0,0,0]
    System.out.println(Arrays.toString(res));
  }
}
