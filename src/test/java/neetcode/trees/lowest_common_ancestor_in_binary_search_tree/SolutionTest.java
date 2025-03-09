package neetcode.trees.lowest_common_ancestor_in_binary_search_tree;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(1,
                                        null,
                                        new TreeNode(2)),
                                new TreeNode(4)),
                        new TreeNode(8,
                                new TreeNode(7),
                                new TreeNode(9)));
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(8);
        Solution solution = new Solution();
        TreeNode actual = solution.lowestCommonAncestor(root, p, q);
        Assertions.assertEquals(5, actual.val);
    }

    @Test
    void example1() {
        TreeNode root =
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(1,
                                        null,
                                        new TreeNode(2)),
                                new TreeNode(4)),
                        new TreeNode(8,
                                new TreeNode(7),
                                new TreeNode(9)));
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(4);
        Solution solution = new Solution();
        TreeNode actual = solution.lowestCommonAncestor(root, p, q);
        Assertions.assertEquals(3, actual);
    }

}