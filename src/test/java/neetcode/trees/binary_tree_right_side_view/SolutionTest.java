package neetcode.trees.binary_tree_right_side_view;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3));
        Solution solution = new Solution();
        List<Integer> actual = solution.rightSideView(root);

        List<Integer> expected = List.of(1,3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example2() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3,
                                new TreeNode(6),
                                new TreeNode(7)));
        Solution solution = new Solution();
        List<Integer> actual = solution.rightSideView(root);

        List<Integer> expected = List.of(1,3, 7);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example3() {
        TreeNode root =
                new TreeNode(1, new TreeNode(2), null);
        Solution solution = new Solution();
        List<Integer> actual = solution.rightSideView(root);

        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example4() {
        TreeNode root = new TreeNode(0);
        Solution solution = new Solution();
        List<Integer> actual = solution.rightSideView(root);

        List<Integer> expected = List.of(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example5() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                null),
                        new TreeNode(3));
        Solution solution = new Solution();
        List<Integer> actual = solution.rightSideView(root);

        List<Integer> expected = List.of(1,3,4);
        Assertions.assertEquals(expected, actual);
    }

}