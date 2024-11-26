public class Main {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 3};
    int[] nums2 = {1, 2, 3, 4};
    Solution solution = new Solution();
    boolean result = solution.hasDuplicate(nums1);
    System.out.println(result); // true
    result = solution.hasDuplicate(nums2);
    System.out.println(result); // false
  }
}

