package neetcode.stack.minimum_stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Integer> list = new ArrayList<>();

    public MinStack() {

    }

    public void push(int val) {
        list.add(0, val);
    }

    public void pop() {
        if (list.isEmpty()) return;
        list.remove(0);
    }

    public int top() {
        if (list.isEmpty()) return 0;
        return list.get(0);
    }

    public int getMin() {
        if (list.isEmpty()) return 0;
        var min = list.get(0);
        for (Integer n : list) {
            min = Math.min(n, min);
        }
        return min;
    }
}

