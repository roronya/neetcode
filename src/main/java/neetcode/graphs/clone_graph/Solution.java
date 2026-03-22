package neetcode.graphs.clone_graph;

import java.util.*;

class Solution {
    /**
     * nodeを舐めつつ、エッジも作っていく
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        oldToNew.put(node, new Node(node.val));
        q.add(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nei : cur.neighbors) {
                if (!oldToNew.containsKey(nei)) {
                    oldToNew.put(nei, new Node(nei.val));
                    q.add(nei);
                }
                oldToNew.get(cur).neighbors.add(oldToNew.get(nei));
            }
        }
        return oldToNew.get(node);
    }

    /**
     * 探索ですべてのNodeを洗い出し、インスタンスを作成し、{val: Node}の辞書を作っておく
     * もう一度探索し、各Nodeのneighborsに対応するNodeを新しいNodeにsetしていく
     * time complexity: O(V + E)
     * space complexity: O(V)
     */
    public Node myFirstCloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> q = new LinkedList<>();
        Map<Integer, Node> m = new HashMap<>();
        q.add(node);
        while (!q.isEmpty()) {
            System.out.println("q: " + Arrays.toString(q.toArray()));
            Node n = q.remove();
            m.put(n.val, new Node(n.val));
            for (Node ni : n.neighbors) if (m.get(ni.val) == null) q.add(ni);
        }

        System.out.println("map: " + Arrays.toString(m.keySet().toArray()));
        q.add(node);
        Set<Node> visited = new HashSet<>();
        visited.add(node);
        while (!q.isEmpty()) {
            Node n = q.remove();
            Node nn = m.get(n.val);
            for (Node ni : n.neighbors) {
                nn.neighbors.add(m.get(ni.val));
                if (!visited.contains(ni)) {
                    q.add(ni);
                    visited.add(ni);
                }
            }
        }
        return m.get(node.val);
    }
}