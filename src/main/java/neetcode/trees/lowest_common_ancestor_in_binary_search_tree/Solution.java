package neetcode.trees.lowest_common_ancestor_in_binary_search_tree;

import neetcode.trees.TreeNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return mySolution(root, p, q);
    }

    /**
     * pとqの場所を確定させる time complexity: O(2 * log(n))
     * rootに遡っていく time complexity: O(2 * log(n))
     * pがrootまで遡ったときにパンくずを落としてく space complexity: O(n)
     * qがパンくずを確認しながら遡り、初めて見つけたときそれがans
     */
    TreeNode mySolution(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        HashSet<TreeNode> set = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (Objects.isNull(node)) continue;
            set.add(node);
            if (node.val == p.val) break;

            if (node.val > p.val) stack.push(node.left);
            else stack.push(node.right);
        }
        System.out.println(set);
        stack = new Stack<>();
        stack.push(root);
        TreeNode res = root;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (Objects.isNull(node)) continue;
            if (set.contains(node)) res = node;
            else break;
            if (node.val > q.val) stack.push(node.left);
            else stack.push(node.right);
        }
        return res;
    }
}
