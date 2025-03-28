package neetcode.trees.diameter_of_binary_tree;

import neetcode.trees.TreeNode;

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return deepFirstSearch(root);
    }

    int bruteForce(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        int diameter = leftHeight + rightHeight;
        int sub = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(diameter, sub);
    }

    public int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    /**
     * ナイーブなやり方としてleave to leaveの経路の全探索が考えられる
     * O(n^2) as n = count of leavesの計算量になる
     * DPっぽく溶けるか？
     * 各ノードのmax経路を保存しておくとか
     * V字を書いたときのパスがrootからleaveまでの経路より長いことあるのか？(ありそう)
     * [1,2,3,4,5,6] 4→3→2→5→6みたいなV字をどう探索するか
     * rootより１個下のノードでのV字が一番長い経路になる。これを再帰的に適用するでOKぽい。
     * それを幅か深で探索する
     * ^の形を下から探っていって一番長いやつを探す。
     */
    int deepFirstSearch(TreeNode root) {
        if (root == null) return 0;
        int[] ans = {0};
        dfs(root, ans);
        return ans[0];
    }

    int dfs(TreeNode node, int[] ans) {
        if (node == null) return 0;
        int l = dfs(node.left, ans);
        int r = dfs(node.right, ans);
        ans[0] = Math.max(ans[0], l + r);
        return 1 + Math.max(l, r);
    }
}

