package neetcode.tries.implement_trie;


class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new Node();
            }
            cur = cur.children[i];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            cur = cur.children[i];
            if (cur == null) return false;
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char ch : prefix.toCharArray()) {
            int i = ch - 'a';
            cur = cur.children[i];
            if (cur == null) return false;
        }
        return true;
    }
}

class Node {
    Node[] children = new Node[26];
    boolean endOfWord = false;
}
