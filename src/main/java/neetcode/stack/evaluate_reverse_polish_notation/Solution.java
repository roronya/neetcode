package neetcode.stack.evaluate_reverse_polish_notation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    @FunctionalInterface
    interface Operator {
        int apply(int a, int b);
    }

    public int evalRPN(String[] tokens) {
        Map<String, Operator> operatorMap = new HashMap<>();
        operatorMap.put("+", (a, b) -> a + b);
        operatorMap.put("-", (a, b) -> a - b);
        operatorMap.put("*", (a, b) -> a * b);
        operatorMap.put("/", (a, b) -> a / b);

        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            System.out.println(stack);
            switch (token) {
                case "+", "-", "*", "/":
                    Integer b = Integer.valueOf(stack.pop());
                    Integer a = Integer.valueOf(stack.pop());
                    Operator f = operatorMap.get(token);
                    stack.push(String.valueOf(f.apply(a, b)));
                    break;
                default:
                    stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}