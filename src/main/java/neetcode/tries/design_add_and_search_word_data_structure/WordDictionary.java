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
    }

    public boolean search(String word) {
        Node cur = root;
        Queue<Node> q = new LinkedList<>();
        q.add(cur);
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            Queue<Node> newQ = new LinkedList<>();
            while (!q.isEmpty()) {
                Node node = q.remove();
                if (ch == '.') {
                    for (Node c : node.children) {
                        if (c != null) newQ.add(c);
                    }
                } else {
                    int j = ch - 'a';
                    if (node.children[j] == null) return false;
                    newQ.add(node.children[j]);
                }
            }
            if (newQ.isEmpty()) return false;
            q = newQ;
        }
        return true;
    }
}

class Node {
    Node[] children = new Node[26];
}