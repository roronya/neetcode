package neetcode.trees.serialize_and_deserialize_binary_tree;

import neetcode.trees.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CodecTest {
    @Test
    void example1() {
        TreeNode root =
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(3,
                                new TreeNode(4),
                                new TreeNode(5)));
        Codec codec = new Codec();
        TreeNode actual = codec.deserialize(codec.serialize(root));
        Assertions.assertEquals(root, actual);
    }

    @Test
    void example2() {
        TreeNode root = new TreeNode();
        Codec codec = new Codec();
        TreeNode actual = codec.deserialize(codec.serialize(root));
        Assertions.assertEquals(root, actual);
    }
}