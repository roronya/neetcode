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
     * time complexity: O(n^2)
     * whileループを全ノードに対して行うため
     *
     * O(n)を目指したいが、解説もこの方式なので一旦これで…
     */
    int preIndex = 0;
    TreeNode mySolution(int[] preorder, int[] inorder) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(preorder, preIndex, preorder.length)) + ":" + Arrays.toString(inorder));
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        int inorderIndex = 0;
        while(inorder[inorderIndex] != preorder[preIndex]) inorderIndex++;
        preIndex++;
        root.left = mySolution(preorder, Arrays.copyOfRange(inorder, 0, inorderIndex));
        root.right = mySolution(preorder, Arrays.copyOfRange(inorder, inorderIndex + 1, inorder.length));
        return root;
    }
}

