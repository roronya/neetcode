package neetcode.trees.count_good_nodes_in_binary_tree;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(2,
                        new TreeNode(1,
                                new TreeNode(3),
                                null),
                        new TreeNode(1,
                                new TreeNode(1),
                                new TreeNode(5)));
        Solution solution = new Solution();
        int actual = solution.goodNodes(root);
        Assertions.assertEquals(3, actual);
    }

    @Test
    void example2() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(4)),
                        new TreeNode(-1));
        Solution solution = new Solution();
        int actual = solution.goodNodes(root);
        Assertions.assertEquals(4, actual);
    }
}