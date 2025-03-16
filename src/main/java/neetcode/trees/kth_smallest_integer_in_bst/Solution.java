package neetcode.trees.kth_smallest_integer_in_bst;

import neetcode.trees.TreeNode;

import java.util.Stack;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return mySolution(root, k);
    }

    /**
     * stackに小さい順で積みたい
     * まずleftをすべて積んでおく
     * 探索を始める
     * 探索対象にrightがあればrightをstackに積んだあとにleftをすべて積む
     * time complexity: O(n)
     * space complexity: O(n)
     */
    int mySolution(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.add(cur);
            cur = cur.left;
        }

        int i = 0;
        while (!stack.isEmpty()) {
            System.out.println(stack);
            i++;
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (i == k) return node.val;
            cur = node.right;
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
        }
        return 0; // なんでもいい sizeof TreeNode > k のはず
    }
}

