package neetcode.trees.subtree_of_another_tree;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3));
        TreeNode subRoot =
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5));
        Solution solution = new Solution();

        boolean actual = solution.isSubtree(root, subRoot);
        Assertions.assertTrue(actual);
    }

    @Test
    void example2() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(6),
                                        null),
                                new TreeNode(5)),
                        new TreeNode(3));
        TreeNode subRoot =
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5));
        Solution solution = new Solution();

        boolean actual = solution.isSubtree(root, subRoot);
        Assertions.assertFalse(actual);
    }
}