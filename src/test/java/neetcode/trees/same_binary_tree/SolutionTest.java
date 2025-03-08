package neetcode.trees.same_binary_tree;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode p =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3));
        TreeNode q =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3));
        Solution solution = new Solution();
        boolean actual = solution.isSameTree(p, q);
        Assertions.assertTrue(actual);
    }

    @Test
    void example2() {
        TreeNode p =
                new TreeNode(
                        4,
                        new TreeNode(7),
                        null
                );
        TreeNode q =
                new TreeNode(
                        4,
                        null,
                        new TreeNode(7)
                );
        Solution solution = new Solution();
        boolean actual = solution.isSameTree(p, q);
        Assertions.assertFalse(actual);
    }
}