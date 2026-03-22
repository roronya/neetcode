package neetcode.graphs.clone_graph;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{val: ");
        sb.append(val);
        sb.append(", neighbors: ");
        sb.append("[");
        for (Node n : neighbors) {
            sb.append(n.val);
            sb.append(",");
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }
}
