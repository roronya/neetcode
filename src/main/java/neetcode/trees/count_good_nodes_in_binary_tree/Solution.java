package neetcode.trees.count_good_nodes_in_binary_tree;

import neetcode.trees.TreeNode;

class Solution {
    public int goodNodes(TreeNode root) {
        return mySolution(root);
    }

    int mySolution(TreeNode root) {
        int[] ans = new int[]{0};
        dfs(root, root.val, ans);
        return ans[0];
    }

    void dfs(TreeNode node, int x, int[] ans) {
        if (node == null) return;
        if (node.val >= x) {
            ans[0]++;
            x = node.val;
        }

        dfs(node.left, x, ans);
        dfs(node.right, x, ans);
    }
}
