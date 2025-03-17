package neetcode.trees.construct_binary_tree_from_preorder_and_inorder_traversal;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void example1() {
        // Input: preorder = [1,2,3,4], inorder = [2,1,3,4]
        //Output: [1,2,3,null,null,null,4]
        /**
         * preorderだけだと
         * 1
         * 2 3
         * 4
         * か
         * 1
         * 2
         * 3 4
         * か見比べがつかない
         * inorderもあると
         * 1
         * 2   3
         * n n 4 n
         *
         * 1
         * 2   3
         * n n n 4
         * の見分けはつかない
         */
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {2, 1, 3, 4};
        Solution solution = new Solution();
        TreeNode actual = solution.buildTree(preorder, inorder);

        TreeNode expected =
                new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3,
                                null,
                                new TreeNode(4)));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void example2() {
        int[] preorder = {1};
        int[] inorder = {1};
        Solution solution = new Solution();
        TreeNode actual = solution.buildTree(preorder, inorder);

        TreeNode expected =
                new TreeNode(1);
        Assertions.assertEquals(expected, actual);
    }
}