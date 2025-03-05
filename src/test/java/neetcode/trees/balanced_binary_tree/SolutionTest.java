package neetcode.trees.balanced_binary_tree;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(
                                3,
                                new TreeNode(4),
                                null));
        Solution solution = new Solution();
        boolean actual = solution.isBalanced(root);
        Assertions.assertTrue(actual);
    }

    @Test
    void example2() {
        TreeNode root =
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(
                                3,
                                new TreeNode(
                                        4,
                                        new TreeNode(5),
                                        null),
                                null));
        Solution solution = new Solution();
        boolean actual = solution.isBalanced(root);
        Assertions.assertFalse(actual);
    }

    @Test
    void example3() {
        TreeNode root = new TreeNode();
        Solution solution = new Solution();
        boolean actual = solution.isBalanced(root);
        Assertions.assertTrue(actual);
    }

    @Test
    void example4() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3,
                                        new TreeNode(4),
                                        null),
                                null),
                        new TreeNode(2,
                                null,
                                new TreeNode(3,
                                        null,
                                        new TreeNode(4))));
        Solution solution = new Solution();
        boolean actual = solution.isBalanced(root);
        Assertions.assertFalse(actual);
    }
}