package neetcode.tries.design_add_and_search_word_data_structure;

import java.util.LinkedList;
import java.util.Queue;

class TrieNode {
    TrieNode[] children;
    boolean word;

    public TrieNode() {
        children = new TrieNode[26];
        word = false;
    }
}

class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode cur = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
        }
        return cur.word;
    }

}

class MyWordDictionary {
    Node root;

    public MyWordDictionary() {
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