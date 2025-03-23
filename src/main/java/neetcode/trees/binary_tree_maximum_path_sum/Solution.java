package neetcode.trees.binary_tree_maximum_path_sum;

import neetcode.trees.TreeNode;

class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // dfs(root);
        optimalDfs(root);
        return res;
    }

    private int getMax(TreeNode root) {
        if (root == null) return 0;
        int left = getMax(root.left);
        int right = getMax(root.right);
        int path = root.val + Math.max(left, right);
        return Math.max(0, path);
    }

    /**
     * leftとrightそれぞれのmax経路を足す
     * resにその最大値を保存していく
     * dfsでleftとrightをそれぞれ見ていく
     * O(n^2)
     *
     * O(n)にできるか
     * 上から調べるからすべてのNodeについてO(n)の探索になってしまう
     * 下から調べて上に上がっていけば全体でO(n)にできる
     */
    private void dfs(TreeNode root) {
        if (root == null) return;
        int left = getMax(root.left);
        int right = getMax(root.right);
        res = Math.max(res, root.val + left + right);
        dfs(root.left);
        dfs(root.right);
    }

    /**
     *
     * @param root
     * @return そのNodeでの最大値(右か左かの最大の方を選んだときの値に自身を足して返す
     */
    private int optimalDfs(TreeNode root) {
        if (root == null) return 0;
        // leftやrightを選ぶとむしろマイナスになるケースがあるので0と比較する
        int leftMax = Math.max(optimalDfs(root.left), 0);
        int rightMax = Math.max(optimalDfs(root.right), 0);

        // 上のNodeではなくこのノードで経路を構築した場合どうかというのをメモしておく
        res = Math.max(res, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
