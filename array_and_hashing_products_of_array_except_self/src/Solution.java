import java.util.Arrays;

public class Solution {
  public int[] productExceptSelf(int[] nums) {
    return productExceptSelfOwn(nums);
  }
  // time complexity: O(n^2)
  // space complexity: O(n)
  public int[] productExceptSelfNaive(int[] nums) {
    int[] res = new int[nums.length];
    for (int i=0;i<nums.length;i++) {
      res[i] = 1;
      for (int j=0;j<nums.length;j++) {
        if (i != j) {
          res[i] *= nums[j];
        }
      }
    }
    return res;
  }

  // 自分の前と後を計算しておいて最後にか合わせるというアイデア
  public int[] productExceptSelfPrefixAndSuffix(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    int[] pref = new int[n];
    int[] suff = new int[n];

    pref[0] = 1;
    suff[n - 1] = 1;
    for (int i = 1; i < n; i++) {
      pref[i] = nums[i - 1] * pref[i - 1];
    }
    System.out.println(Arrays.toString(pref));
    for (int i = n - 2; i >= 0; i--) {
      suff[i] = nums[i + 1] * suff[i + 1];
    }
    System.out.println(Arrays.toString(suff));
    for (int i = 0; i < n; i++) {
      res[i] = pref[i] * suff[i];
    }
    return res;
  }

  // Prefix&Suffixの変数名を使い回すことでspace complexityを効率化している
  public int[] productExceptSelfOptimal(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];

    res[0] = 1;
    for (int i = 1; i < n; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }

    int postfix = 1;
    for (int i = n - 1; i >= 0; i--) {
      res[i] *= postfix;
      postfix *= nums[i];
    }
    return res;
  }

  public int[] productExceptSelfOwn(int[] nums) {
    int[] res = new int[nums.length];
    res[0] = 1; // 0番目は計算不要なのと、1番目のために代入しておく
    // calc prefix
    for (int i=1;i<res.length;i++) {
      res[i] = res[i-1] * nums[i-1];
    }
    // calc postfix
    int postfix = 1; // 末尾から計算していく。今度は末尾から1番目のために1で初期化しておく
    for (int i=nums.length-1;i>=0;i--) {
      res[i] *= postfix;
      postfix *= nums[i];
    }
    return res;
  }
}

