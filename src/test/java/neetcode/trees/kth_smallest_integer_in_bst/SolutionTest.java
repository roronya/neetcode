package neetcode.trees.kth_smallest_integer_in_bst;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3));
        int k = 1;
        Solution solution = new Solution();
        int actual = solution.kthSmallest(root, k);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void example2() {
        // Input: root = [4,3,5,2,null], k = 4
        TreeNode root =
                new TreeNode(4,
                        new TreeNode(3,
                                new TreeNode(2),
                                null),
                        new TreeNode(5));
        int k = 4;
        Solution solution = new Solution();
        int actual = solution.kthSmallest(root, k);
        Assertions.assertEquals(5, actual);
    }
}