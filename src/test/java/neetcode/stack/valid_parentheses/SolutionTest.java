package neetcode.stack.valid_parentheses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution solution = new Solution();

  @Test
  void example1() {
    String s = "[]";
    var actual = solution.isValid(s);
    assertTrue(actual);
  }

  @Test
  void example2() {
    String s = "([{}])";
    var actual = solution.isValid(s);
    assertTrue(actual);
  }

  @Test
  void example3() {
    String s = "[(])";
    var actual = solution.isValid(s);
    assertFalse(actual);
  }

  @Test
  void example4() {
    String s = "[";
    var actual = solution.isValid(s);
    assertFalse(actual);
  }
}
