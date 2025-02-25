package neetcode.binary_search.search_in_rotated_sorted_array;

public class Solution {
    int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) {
                if (nums[m] < target || target < nums[l]) l = m + 1;
                else r = m - 1;
            } else { // nums[m] <= nums[r]
                if (target < nums[m] || nums[r] < target) r = m - 1;
                else l = m + 1;
            }
        }
        return -1;
    }

    /**
     * t=1
     * [5,6,0,1,2,3,4] l>t  && t<m
     * [1,2,3,4,5] l<=t && t<m
     * [4,5,1,2,3] l<=t && t<m
     * [5,1,2,3,4] t<r<m
     */
    int mySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            System.out.println(l + ":" + r);
            int m = (l + r) / 2;
            if (nums[m] == target) return m;
            if (nums[l] <= nums[r]) {
                if (nums[m] < target) l = m + 1;
                else r = m - 1;
            } else {
                if (target < nums[m]) {
                    if (nums[l] <= target) r = m - 1; // l <= t < m
                    else l = m + 1; // target < nums[m] < nums[l] -> m < t <= r
                } else { // nums[m] < target
                    if (target <= nums[r]) l = m + 1;// m < t <= r
                    else r = m - 1; // m < r < t -> l<= t
                }
            }
        }
        return -1;
    }
}
