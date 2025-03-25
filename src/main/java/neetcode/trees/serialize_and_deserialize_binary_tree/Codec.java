package neetcode.trees.serialize_and_deserialize_binary_tree;

import neetcode.trees.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    // time complexity: O(n) 全ノードをbfsで舐めてる。
    // space complexity: O(n) bfsのために使うQueueのスペースが必要
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            if (sb.length() != 1) {
                sb.append(",");
            }
            TreeNode n = q.remove();
            if (n == null) {
                sb.append("null");
                continue;
            }
            sb.append(n.val);
            q.add(n.left);
            q.add(n.right);
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // time complexity: O(n) + O(n) = O(n) lexerでStringを舐める。木の再構築にbfsでtokenをすべて舐める
    // space complexity: O(n) tokenを保存するLinkedListと再構築に使うQueueのスペースが必要
    public TreeNode deserialize(String data) {
        LinkedList<String> tokens = new LinkedList<>();
        // lexer
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '[') continue;
            StringBuilder sb = new StringBuilder();
            while (data.charAt(i) != ',' && data.charAt(i) != ']') {
                sb.append(data.charAt(i));
                i++;
                // System.out.println(sb);
            }
            tokens.add(sb.toString());
            // System.out.println(tokens);
        }

        // [1,2,3,null,null,4,5,null,null,null,null]
        if (tokens.isEmpty() || Objects.equals(tokens.getFirst(), "null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(tokens.remove()));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!tokens.isEmpty()) {
            //System.out.println("tokens:" + tokens);
            // System.out.println("queue:" + q);
            String left = tokens.remove();
            String right = tokens.remove();
            // System.out.println("left:right=" + left + ":" + right);
            TreeNode cur = q.remove();
            cur.left = Objects.equals(left, "null") ? null : new TreeNode(Integer.parseInt(left));
            cur.right = Objects.equals(right, "null") ? null : new TreeNode(Integer.parseInt(right));
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
        return root;
    }
}

