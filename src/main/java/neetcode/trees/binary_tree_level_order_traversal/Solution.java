package neetcode.trees.binary_tree_level_order_traversal;

import neetcode.trees.TreeNode;

import java.util.*;

public class Solution {
    class Pair {
        Integer level;
        TreeNode node;

        public Pair(Integer level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        return mySolution(root);
    }

    /**
     * 幅優先探索で良さそうだが、いびつなツリーだとレベルが揃わないかも
     * バランス木ではないから、左や右に寄ったツリーはできてしまいそう。
     * レベルは覚えている必要がありそう。
     * 初期値1, 2, 4, 8, ... = 2^nの配列
     * time complexity: O(logn)
     * space complexity: O(logn)
     */
    public List<List<Integer>> mySolution(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair> queue = new ArrayDeque<>();
        int level = 0;
        queue.add(new Pair(level, root));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.level + 1 > res.size()) {
                ArrayList<Integer> newLebel = new ArrayList<>();
                newLebel.add(pair.node.val);
                res.add(newLebel);
            } else {
                res.get(pair.level).add(pair.node.val);
            }
            if (Objects.nonNull(pair.node.left)) queue.add(new Pair(pair.level + 1, pair.node.left));
            if (Objects.nonNull(pair.node.right)) queue.add(new Pair(pair.level + 1, pair.node.right));
        }
        return res;
    }

}
