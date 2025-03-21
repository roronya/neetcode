package neetcode.trees.binary_tree_maximum_path_sum;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3));
        Solution solution = new Solution();
        int actual = solution.maxPathSum(root);
        Assertions.assertEquals(6, actual);
    }

    @Test
    void example2() {
        TreeNode root =
                new TreeNode(-15,
                        new TreeNode(10),
                        new TreeNode(20,
                                new TreeNode(15,
                                        new TreeNode(-5),
                                        null),
                                new TreeNode(5)));
        Solution solution = new Solution();
        int actual = solution.maxPathSum(root);
        Assertions.assertEquals(40, actual);
    }
}