package neetcode.trees;


import java.util.ArrayList;
import java.util.LinkedList;

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
        ArrayList<Integer> integers = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top == null) {
                integers.add(null);
                continue;
            }
            integers.add(top.val);
            queue.add(top.left);
            queue.add(top.right);
        }
        return integers.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object.getClass() != TreeNode.class) return false;
        return object.toString().equals(this.toString());
    }
}
