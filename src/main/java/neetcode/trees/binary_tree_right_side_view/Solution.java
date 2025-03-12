package neetcode.trees.binary_tree_right_side_view;

import neetcode.trees.TreeNode;

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       return mySolution(root);
    }

    /**
     * 一番右から見たときにあるやつというのを定義するべきっぽい
     * siblingの中で最も右にあるやつ
     * 各レベルで最も右にあるやつ(stackのtop)をres.addする
     * 次の階層のnodeを左からstackに積む
     * time complexity: O(h * 2h) = O(h)
     * space complexity: O(2h)
     * h is size of last layer of tree
     */
    public List<Integer> mySolution(TreeNode root) {
        if (root == null) return Collections.emptyList();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);

        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != null) res.add(top.val);

            stack = new Stack<>();
            if (top.right != null) stack.add(top.right);
            else if (top.left != null) stack.add(top.left);
        }
        return res;
    }
}
