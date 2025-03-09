package neetcode.trees.binary_tree_level_order_traversal;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7)));
        List<List<Integer>> actual = new Solution().levelOrder(root);
        List<List<Integer>> expected =
                List.of(List.of(1),
                        List.of(2, 3),
                        List.of(4, 5, 6, 7));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example2() {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> actual = new Solution().levelOrder(root);
        List<List<Integer>> expected = List.of(List.of(1));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example3() {
        TreeNode root = new TreeNode();
        List<List<Integer>> actual = new Solution().levelOrder(root);
        List<List<Integer>> expected = List.of(List.of());
        Assertions.assertEquals(expected, actual);
    }
}