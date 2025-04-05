package neetcode.tries.design_add_and_search_word_data_structure;

import java.util.LinkedList;
import java.util.Queue;

class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new Node();
            }
            cur = cur.children[i];
        }
        cur.isEnd = true;
        System.out.println(root);
        System.out.println(cur);
    }

    public boolean search(String word) {
        Node cur = root;
        Queue<Node> q = new LinkedList<>();
        q.add(cur);
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            Queue<Node> newQ = new LinkedList<>();
            System.out.println("---------");
            System.out.println("q: " + q);
            while (!q.isEmpty()) {
                Node node = q.remove();
                System.out.println(node);
                if (ch == '.') {
                    for (Node c : node.children) {
                        if (c != null) newQ.add(c);
                    }
                } else {
                    int j = ch - 'a';
                    if (node.children[j] != null) newQ.add(node.children[j]);
                }
            }
            System.out.println("newQ: " + newQ);
            if (newQ.isEmpty()) return false;
            q = newQ;
        }
        for (Node n : q) {
            if (n.isEnd) return true;
        }
        return false;
    }
}

class Node {
    Node[] children = new Node[26];
    boolean isEnd = false;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (children[i] != null) {
                sb.append(Character.toChars('a' + i));
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}