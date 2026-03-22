package neetcode.graphs.clone_graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class SolutionTest {
    boolean isCloned(Node n, Node m) {
        if (n == null && m == null) return true;
        if (n == null && m != null || n != null && m == null) return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(n);
        q2.add(m);
        HashSet<Node> m1 = new HashSet<>();
        HashSet<Node> m2 = new HashSet<>();
        m1.add(n);
        m2.add(m);
        while (!(q1.isEmpty() || q2.isEmpty())) {
            System.out.println("m1: " + Arrays.toString(m1.toArray()));
            System.out.println("m2: " + Arrays.toString(m2.toArray()));
            Node p1 = q1.remove();
            Node p2 = q2.remove();
            if (p1 == p2) return false; // mustn't be same reference
            if (p1.val != p2.val) return false; // must be same val
            if (p1.neighbors.size() != p2.neighbors.size()) return false;
            for (Node nn : p1.neighbors) {
                if (!m1.contains(nn)) {
                    q1.add(nn);
                    m1.add(nn);
                }
            }
            for (Node nn : p2.neighbors) {
                if (!m2.contains(nn)) {
                    q2.add(nn);
                    m2.add(nn);
                }
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }

    /**
     * Input: adjList = [[2],[1,3],[2]]
     * <p>
     * Output: [[2],[1,3],[2]]
     */
    @Test
    void example1() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.neighbors.add(n2);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);

        Solution solution = new Solution();
        Node actual = solution.cloneGraph(n1);
        System.out.println(n1);
        System.out.println(actual);
        Assertions.assertTrue(isCloned(n1, actual));
    }

    @Test
    void example2() {
        Node n1 = new Node();
        Solution solution = new Solution();
        Node actual = solution.cloneGraph(n1);
        Assertions.assertTrue(isCloned(n1, actual));
    }

    @Test
    void example3() {
        Node n1 = null;
        Solution solution = new Solution();
        Node actual = solution.cloneGraph(n1);
        Assertions.assertTrue(isCloned(n1, actual));
    }

    @Nested
    class isCloned {
        @Test
        void shouldBeTrue() {
            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            n1.neighbors.add(n2);
            n2.neighbors.add(n1);
            n2.neighbors.add(n3);
            n3.neighbors.add(n2);

            Node m1 = new Node(1);
            Node m2 = new Node(2);
            Node m3 = new Node(3);
            m1.neighbors.add(m2);
            m2.neighbors.add(m1);
            m2.neighbors.add(m3);
            m3.neighbors.add(m2);

            Assertions.assertTrue(isCloned(n1, m1));
        }

        @Test
        void shouldBeFalse() {
            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            n1.neighbors.add(n2);
            n2.neighbors.add(n1);
            n2.neighbors.add(n3);
            n3.neighbors.add(n2);

            Assertions.assertFalse(isCloned(n1, n1));
        }

        @Test
        void shouldBeFalse2() {
            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            n1.neighbors.add(n2);
            n2.neighbors.add(n1);
            n2.neighbors.add(n3);
            n3.neighbors.add(n2);

            Assertions.assertFalse(isCloned(n1, new Node(-1)));
        }
    }

}