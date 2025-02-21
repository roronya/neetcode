package neetcode.binary_search.koko_eating_bananas;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;
        int ans = 1;
        while (left <= right) {
            int k = (left + right) / 2;
            System.out.println(left + ":" + right + "=>" + k);
            int s = eat(piles, k);
            if (s <= h) {
                ans = k;
                right = k - 1;
            } else left = k + 1;
        }
        return ans;
    }

    int eat(int[] piles, int k) {
        assert k != 0;
        int count = 0;
        for (int p : piles) {
            count += p / k + (p % k == 0 ? 0 : 1);
        }
        return count;
    }
}

