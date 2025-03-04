package neetcode.trees.maximum_depth_of_binary_tree;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        null));

        Solution solution = new Solution();
        int actual = solution.maxDepth(root);
        Assertions.assertEquals(3, actual);
    }

    @Test
    void example2() {
        TreeNode root = new TreeNode();

        Solution solution = new Solution();
        int actual = solution.maxDepth(root);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void example3() {
        TreeNode root = null;

        Solution solution = new Solution();
        int actual = solution.maxDepth(root);
        Assertions.assertEquals(0, actual);
    }

    @Test
    void example4() {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        null),
                new TreeNode(
                        3,
                        null,
                        new TreeNode(5)));

        Solution solution = new Solution();
        int actual = solution.maxDepth(root);
        Assertions.assertEquals(3, actual);
    }
}