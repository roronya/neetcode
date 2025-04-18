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


    @Test
    void example3() {
        TreeNode root =
                new TreeNode(2,
                        null,
                        new TreeNode(4,
                                new TreeNode(10),
                                new TreeNode(8,
                                        new TreeNode(4),
                                        null)));
        Solution solution = new Solution();
        int actual = solution.goodNodes(root);
        Assertions.assertEquals(4, actual);
    }

    //root=[3,1,4,3,null,1,5]
    @Test
    void example4() {
        TreeNode root =
                new TreeNode(3,
                        new TreeNode(1,
                                new TreeNode(3),
                                null),
                        new TreeNode(4,
                                new TreeNode(1),
                                new TreeNode(5)));
        Solution solution = new Solution();
        int actual = solution.goodNodes(root);
        Assertions.assertEquals(4, actual);
    }

}