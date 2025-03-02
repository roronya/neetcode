package neetcode.trees.invert_binary_tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(3);
        expected.right = new TreeNode(2);
        expected.left.left = new TreeNode(7);
        expected.left.right = new TreeNode(6);
        expected.right.left = new TreeNode(5);
        expected.right.right = new TreeNode(4);

        Solution solution = new Solution();
        TreeNode actual = solution.invertTree(root);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example2() {
        TreeNode root = new TreeNode(3);
        System.out.println(root);
        root.left = new TreeNode(2);
        System.out.println(root.left.val);
        root.right = new TreeNode(1);
        System.out.println(root);

        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(1);
        expected.right = new TreeNode(2);

        Solution solution = new Solution();
        TreeNode actual = solution.invertTree(root);

        Assertions.assertEquals(expected, actual);
    }
}