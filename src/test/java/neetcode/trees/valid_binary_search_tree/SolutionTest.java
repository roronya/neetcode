package neetcode.trees.valid_binary_search_tree;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3));
        Solution solution = new Solution();
        boolean actual = solution.isValidBST(root);
        Assertions.assertTrue(actual);
    }

    @Test
    void example2() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3));
        Solution solution = new Solution();
        boolean actual = solution.isValidBST(root);
        Assertions.assertFalse(actual);
    }

    @Test
    void example3() {
        TreeNode root =
                new TreeNode(2,
                        new TreeNode(2),
                        new TreeNode(2));
        Solution solution = new Solution();
        boolean actual = solution.isValidBST(root);
        Assertions.assertFalse(actual);
    }

    @Test
    void example4() {
        TreeNode root =
                new TreeNode(5,
                        new TreeNode(4),
                        new TreeNode(6,
                                new TreeNode(3),
                                new TreeNode(7)));
        Solution solution = new Solution();
        boolean actual = solution.isValidBST(root);
        Assertions.assertFalse(actual);
    }

    @Test
    void example5() {
        TreeNode root =
                new TreeNode(1,
                        null,
                        new TreeNode(1));
        Solution solution = new Solution();
        boolean actual = solution.isValidBST(root);
        Assertions.assertFalse(actual);
    }
}