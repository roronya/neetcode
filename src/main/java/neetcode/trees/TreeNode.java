package neetcode.trees;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        if (this.val == 0) return "";
        ArrayList<Integer> integers = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            integers.add(top.val);
            if (Objects.nonNull(top.left)) queue.add(top.left);
            if (Objects.nonNull(top.right)) queue.add(top.right);
        }
        return integers.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object.getClass() != TreeNode.class) return false;
        return object.toString().equals(this.toString());
    }
}
