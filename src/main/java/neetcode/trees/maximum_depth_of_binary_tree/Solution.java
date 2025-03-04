package neetcode.trees.maximum_depth_of_binary_tree;

import neetcode.trees.TreeNode;

import java.util.Objects;

class Solution {
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}


