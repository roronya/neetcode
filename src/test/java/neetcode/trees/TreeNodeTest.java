package neetcode.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class TreeNodeTest {
    @Nested
    class toString {

        @Test
        void val_equals_zero() {
            TreeNode treeNode = new TreeNode();
            String actual = treeNode.toString();
            String expected = "[0]";
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void val_equals_one() {
            TreeNode treeNode = new TreeNode(1);
            String actual = treeNode.toString();
            String expected = "[1]";
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void val_equals_one_two_three() {
            TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
            String actual = treeNode.toString();
            String expected = "[1, 2, 3]";
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void tree() {
            TreeNode treeNode =
                    new TreeNode(1,
                            new TreeNode(2,
                                    new TreeNode(4),
                                    new TreeNode(5)),
                            new TreeNode(3,
                                    new TreeNode(6),
                                    new TreeNode(7)));
            String actual = treeNode.toString();
            String expected = "[1, 2, 3, 4, 5, 6, 7]";
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    class equelas {
        @Test
        void shouldBeTrue() {
            TreeNode a =
                    new TreeNode(1,
                            new TreeNode(2,
                                    new TreeNode(4),
                                    new TreeNode(5)),
                            new TreeNode(3,
                                    new TreeNode(6),
                                    new TreeNode(7)));
            TreeNode b =
                    new TreeNode(1,
                            new TreeNode(2,
                                    new TreeNode(4),
                                    new TreeNode(5)),
                            new TreeNode(3,
                                    new TreeNode(6),
                                    new TreeNode(7)));
            Assertions.assertEquals(a, b);
        }

        @Test
        void shouldBeFalse() {
            TreeNode a =
                    new TreeNode(1,
                            new TreeNode(2,
                                    new TreeNode(4),
                                    new TreeNode(5)),
                            new TreeNode(3,
                                    new TreeNode(6),
                                    new TreeNode(7)));
            TreeNode b =
                    new TreeNode(100000,
                            new TreeNode(2,
                                    new TreeNode(4),
                                    new TreeNode(5)),
                            new TreeNode(3,
                                    new TreeNode(6),
                                    new TreeNode(7)));
            Assertions.assertNotEquals(a, b);
        }

        @Test
        void shouldBeTrue_emptyTree() {
            TreeNode a = new TreeNode();
            TreeNode b = new TreeNode();
            Assertions.assertEquals(a, b);
        }
    }

}