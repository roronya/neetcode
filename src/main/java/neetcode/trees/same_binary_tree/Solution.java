package neetcode.trees.same_binary_tree;

import neetcode.trees.TreeNode;

import java.util.Objects;
import java.util.Stack;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return mySolution(p, q);
    }

    boolean mySolution(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(p);
        stack.add(q);
        while (!stack.isEmpty()) {
            //System.out.println(queue);
            TreeNode pi = stack.pop();
            TreeNode qi = stack.pop();
            if (Objects.nonNull(pi) && Objects.nonNull(qi)) {
                if (pi.val != qi.val) return false;
            } else if (Objects.isNull(pi) && Objects.isNull(qi)) {
                continue;
            } else {
                return false;
            }
            stack.add(pi.left);
            stack.add(qi.left);
            stack.add(pi.right);
            stack.add(qi.right);
        }
        return true;
    }
}
