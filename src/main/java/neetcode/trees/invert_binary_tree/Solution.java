package neetcode.trees.invert_binary_tree;

import java.util.Objects;
import java.util.Stack;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (Objects.isNull(node)) continue;
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            stack.add(node.left);
            stack.add(node.right);
        }
        return root;
    }
}

