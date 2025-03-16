package neetcode.trees.valid_binary_search_tree;

import neetcode.trees.TreeNode;

import java.util.LinkedList;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return mySolution(root);
    }

    /**
     * 探索は難しい
     * 与えられたTreeNodeから再度BinaryTreeを構築し、それと比較することはできるのでは
     * time complexity: O(nlogn)
     * space compleixty: O(n)
     */
    boolean mySolution(TreeNode root) {
        // rootに含まれる値をすべて取得する O(n); 幅優先探索で値を取得すれば素直にツリーを構築できる順序で取得できるはず
        LinkedList<Integer> values = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        while (!q.isEmpty()) {
            TreeNode last = q.removeLast();
            if (last == null) continue;
            values.addLast(last.val);
            q.addFirst(last.left);
            q.addFirst(last.right);
        }

        // ツリーを再構築する O(nlog); 全要素にたいしてBSTへのinertを実行する
        if (values.isEmpty()) return true;
        TreeNode head = new TreeNode(values.removeFirst());
        while (!values.isEmpty()) {
            Integer value = values.removeFirst();
            TreeNode cur = head;
            TreeNode parent = head;
            while (cur != null) {
                parent = cur;
                if (value < cur.val) cur = cur.left;
                else if (value > cur.val) cur = cur.right;
                else return false;
            }
            if (value < parent.val) parent.left = new TreeNode(value);
            else parent.right = new TreeNode(value);
        }

        // ツリーを比較する O(n);
        q = new LinkedList<>();
        q.addFirst(root);
        q.addFirst(head);
        System.out.println(root);
        System.out.println(head);
        while (!q.isEmpty()) {
            TreeNode a = q.removeLast();
            TreeNode b = q.removeLast();
            if (a == null && b == null) continue;
            if (!(a != null && b != null)) return false;
            if (a.val != b.val) return false;
            q.addFirst(a.left);
            q.addFirst(b.left);
            q.addFirst(a.right);
            q.addFirst(b.right);
        }
        return true;
    }
}
