package neetcode.trees.construct_binary_tree_from_preorder_and_inorder_traversal;


import neetcode.trees.TreeNode;

import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return mySolution(preorder, inorder);
    }

    /**
     * preorder= [1,2,4,5,3,6,7]
     * inorder = [4,2,5,1,3,6,7]
     * 解説見た。
     * preorderのfirstは必ずroot
     * inorderからrootを見つけたら、左がleft,右がrightになる => [4,2,5],[3,6,7]
     * [4,2,5]の中でpreorderの最もindexが若いのは2なので、2がleftの中のrootになる。 => [4], [5]
     * これを再帰的に繰り返してツリーをrebuildできる。
     */
    TreeNode mySolution(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int m = 0;
        for (m = 0; inorder[m] != root.val; m++) ;
        int[] left = Arrays.copyOfRange(inorder, 0, m);
        int[] right = Arrays.copyOfRange(inorder, m + 1, inorder.length);
        int[] newPreorder = Arrays.copyOfRange(preorder, 1, preorder.length);
        root.left = mySolution(newPreorder, left);
        root.right = mySolution(newPreorder, right);
        return root;
    }
}

