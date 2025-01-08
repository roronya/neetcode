package neetcode.sliding_window.best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        return twoPointers(prices);
    }

    // time complexity: O(n^2)
    public int bruteForce(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }
        return ans;
    }

    // [5,4,3,2] => ストレートに一巡すれば終わり
    // [5,4,6,2] => lより大きいやつがいればそこまでlを移す
    // [8, 4, 10, 7] => いまのlより大きいやつにrがあたったときそこに移動する
    public int twoPointers(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
