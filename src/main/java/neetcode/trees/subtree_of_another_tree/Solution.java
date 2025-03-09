package neetcode.trees.subtree_of_another_tree;

import neetcode.trees.TreeNode;

import java.util.Objects;
import java.util.Stack;

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return bruteForce(root, subRoot);
    }

    /**
     * rootの全部のノードからsubRootに適しているか確認する
     * time complexity: O(n^2)
     * space complexity: O(n + m)
     */
    public boolean bruteForce(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (Objects.isNull(node)) continue;
            if (isSame(node, subRoot)) return true;
            stack.push(node.left);
            stack.push(node.right);
        }
        return false;
    }

    public boolean isSame(TreeNode a, TreeNode b) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(a);
        stack.push(b);
        while (!stack.isEmpty()) {
            TreeNode ai = stack.pop();
            TreeNode bi = stack.pop();
            if (Objects.nonNull(ai) && Objects.nonNull(bi)) {
                if (ai.val != bi.val) return false;
            } else if (Objects.isNull(ai) && Objects.isNull(bi)) {
                continue;
            } else {
                return false;
            }
            stack.push(ai.left);
            stack.push(bi.left);
            stack.push(ai.right);
            stack.push(bi.right);
        }
        return true;
    }
}
