package neetcode.trees.binary_tree_right_side_view;

import neetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        return depthFirstSearch(root);
    }

    /**
     * 右側から順に調べていって、各レイヤで一番右のやつを見つけたらそれをいれる
     */
    public List<Integer> depthFirstSearch(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    void dfs(TreeNode node, int depth, List<Integer> ans) {
        if (node == null) return;
        if (depth == ans.size()) ans.add(node.val);
        dfs(node.right, depth + 1, ans);
        dfs(node.left, depth + 1, ans);
    }

    /**
     * 一番右から見たときにあるやつというのを定義するべきっぽい
     * siblingの中で最も右にあるやつ
     * 各レベルで最も右にあるやつ(stackのtop)をres.addする
     * 次の階層のnodeを左からstackに積む
     * time complexity: O(n)
     * space complexity: O(n)
     * h is size of last layer of tree
     */
    public List<Integer> mySolution(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            ans.add(list.getLast().val);
            LinkedList<TreeNode> newList = new LinkedList<>();
            for (TreeNode node : list) {
                if (node.left != null) newList.addLast(node.left);
                if (node.right != null) newList.addLast(node.right);
            }
            list = newList;
        }
        return ans;
    }
}
