package neetcode.two_pointers.trapping_rain_water;

import java.util.Arrays;

public class Solution {
    public int trap(int[] height) {
        int[] maxLefts = new int[height.length];
        int[] maxRights = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            maxLefts[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRights[i] = max;
            max = Math.max(max, height[i]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < maxLefts[i] && height[i] < maxRights[i]) {
                ans += Math.min(maxLefts[i], maxRights[i]) - height[i];
            }
        }
        System.out.println(Arrays.toString(maxLefts));
        System.out.println(Arrays.toString(maxRights));
        return ans;
    }
}
