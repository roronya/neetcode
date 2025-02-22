package neetcode.find_minimum_in_rotated_sorted_array;

class Solution {
    /**
     * [3,4,5,1,2] l=3,r=2,m=5 l<mのとき右を探索したい。mは最小値でないことが保証された。
     * [1,2] l=1,r=2,m=1 l<=m<=rのときsortedなのでlを返す
     * [6,1,2,3,4,5] l=6,m=2,r=5 l>mのとき左を探索したい。mはまだ最小値の可能性がある。
     * [6,1,2] l=6,m=1,r=2 l>mなので左を探索したい。
     * [6,1] l=6,m=6,r=1 l=m
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = nums[0];
        while (l <= r) {
            if (nums[l] < nums[r]) return Math.min(ans, nums[l]);

            int m = (l + r) / 2;
            ans = Math.min(ans, nums[m]);
            if (nums[l] <= nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}

