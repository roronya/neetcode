package neetcode.trees.diameter_of_binary_tree;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(
                        1,
                        null,
                        new TreeNode(
                                2,
                                new TreeNode(
                                        3,
                                        new TreeNode(5),
                                        null
                                ),
                                new TreeNode(4)));

        Solution solution = new Solution();
        int actual = solution.diameterOfBinaryTree(root);
        Assertions.assertEquals(3, actual);
    }

    @Test
    void example2() {
        TreeNode root =
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(3),
                                null
                        ),
                        null
                );

        Solution solution = new Solution();
        int actual = solution.diameterOfBinaryTree(root);
        Assertions.assertEquals(2, actual);
    }

    @Test
    void example3() {
        TreeNode root =
                new TreeNode(
                        1,
                        null,
                        new TreeNode(
                                2,
                                new TreeNode(
                                        3,
                                        null,
                                        new TreeNode(5)),
                                new TreeNode(
                                        4,
                                        null,
                                        new TreeNode(6))));
        Solution solution = new Solution();
        int actual = solution.diameterOfBinaryTree(root);
        Assertions.assertEquals(4, actual);
    }
}