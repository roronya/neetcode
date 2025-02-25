package neetcode.binary_search.search_in_rotated_sorted_array;

public class Solution {
    int search(int[] nums, int target) {
        return mySearch(nums, target);
    }

    /**
     int[] nums = {4,5,6,7,0,1,2};
     */
    int mySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            System.out.println(l + ":" + r);
            int m = (l + r) / 2;
            if (nums[m] == target) return m;
            if (nums[l] < nums[m] && nums[l] <= target && target < nums[m]) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }
}
