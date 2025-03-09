package neetcode.trees.balanced_binary_tree;

import neetcode.trees.TreeNode;

import java.util.Objects;

class Solution {
    /**
     * rightとleftのmax depthを上位ノードに返してleft-rightして2以上ならflase返せば良さそう
     * 探索の途中で枝刈りできそうではある
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean[] res = {true};
        dfs(root, res);
        return res[0];
    }

    int dfs(TreeNode node, boolean[] res) {
        if (Objects.isNull(node)) return 0;
        int l = dfs(node.left, res);
        int r = dfs(node.right, res);
        res[0] = Math.abs(l - r) < 2 && res[0];
        return 1 + Math.max(l, r);
    }
}
