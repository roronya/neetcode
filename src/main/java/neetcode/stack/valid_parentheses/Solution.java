package neetcode.stack.valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    return optimalIsValid(s);
  }
  public boolean myIsValid(String s) {
    Stack<Character> stack = new Stack<>();
    for(Character c: s.toCharArray()) {
      switch (c) {
        case '(', '{', '[' -> stack.add(c);
        case ')' -> {
          if (stack.isEmpty() || stack.peek() != '(')
            return false;
          stack.pop();
        }
        case '}' -> {
          if (stack.isEmpty() || stack.peek() != '{')
            return false;
          stack.pop();
        }
        case ']' -> {
          if (stack.isEmpty() || stack.peek() != '[')
            return false;
          stack.pop();
        }
        default -> {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public boolean optimalIsValid(String s) {
    Map<Character, Character> closeToOpen = new HashMap<>();
    closeToOpen.put(')', '(');
    closeToOpen.put('}', '{');
    closeToOpen.put(']', '[');
    Stack<Character> stack = new Stack<>();
    for (Character c: s.toCharArray()) {
      if (closeToOpen.containsKey(c)) {
        if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
          stack.pop();
        } else {
          return false;
        }
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}

