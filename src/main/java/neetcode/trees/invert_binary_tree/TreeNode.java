package neetcode.trees.invert_binary_tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Objects;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (Objects.isNull(node)) continue;
            list.add(node.val);
            System.out.println(list);
            queue.add(node.left);
            queue.add(node.right);
        }
        return list.toString();
    }

    @Override
    public boolean equals(Object object) {
        return object.toString().equals(this.toString());
    }
}
