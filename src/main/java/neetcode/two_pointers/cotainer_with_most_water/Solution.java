package neetcode.two_pointers.cotainer_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        int ans = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int w = r - l, h = Math.min(height[l], height[r]);
            ans = Math.max(ans, w * h);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return ans;
    }
}
