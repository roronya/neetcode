package neetcode.tries.design_add_and_search_word_data_structure;

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
        for (char ch : word.toCharArray()) {
            if (ch == '.') {
                // childrenすべてが探索対象になる

            } else {
                int i = ch - 'a';
                if (cur.children[i] == null) return false;
                cur = cur.children[i];
            }
        }
        return true;
    }
}

class Node {
    Node[] children = new Node[26];
}