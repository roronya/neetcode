package neetcode.stack.daily_temparatures;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // return bruteForce(temperatures);
        return myStack(temperatures);
    }

    public int[] bruteForce(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int count = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                count++;
                if (temperatures[i] < temperatures[j]) {
                    res[i] = count;
                    break;
                }
            }
        }
        // System.out.println(Arrays.toString(res));
        return res;
    }

    public int[] myStack(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // 0:temp 1:index
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] top = stack.pop();
                ans[top[1]] = i - top[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        System.out.println(stack.stream().map(a -> Arrays.toString(a)).toList());
        return ans;
    }

    /**
     * in:  [30, 38, 30, 36, 35, 40, 28]
     * 探索の対象をStackに積んでおく。自分より大きい値が見つかったら答えに書き込む。
     * 30→38が見つかったときに書き込む
     * 38→40が見つかったときに書き込む
     * 30→36
     * 36, 35→40 whileループで38まで確定させる
     */
    public int[] stack(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
            System.out.println(stack.stream().map(a -> Arrays.toString(a)).toList());
        }
        return res;
    }

    /**
     * idx: [ 0,  1,  2,  3,  4,  5,  6]
     * in:  [30, 38, 30, 36, 35, 40, 28]
     * big: [ 1,  5,  3,  5,  5, -1, -1] # 自分より大きい値がどこに出るか。
     * ans: [ 1,  4,  1,  2,  1,  0,  0] # big-idxで答えを出せる。ただしbigが-1のとき0
     * rev: [28, 40, 35, 36, 30, 38, 30] # bigは自分より先を知らないと計算できないためひっくり返す
     * big: [-1, -1,  1,  1,  3,  1,  5] # 自分より大きい値が配列のそれ以前のどこにあるか。これなら走査できそう？
     * anr: [ 0,  0,  1,  2,  1,  4,  1] # idx-bigでansのrevになる
     * ans: [ 1,  4,  1,  2,  1,  0,  0]
     * 「自分より大きい値がそれ以前のどこにあるか」を保持すれば計算できそう？
     * <p>
     * reverseしないバージョン
     * idx: [ 0,  1,  2,  3,  4,  5,  6]
     * in:  [30, 38, 30, 36, 35, 40, 28]
     * big: [ 1,  5,  3,  5,  5, -1, -1] # 後ろから走査したばあいに自分より大きい値がそれ以前に出現した場所
     * ans: [] # big - idx
     */
    public int[] mySolution(int[] temperatures) {
        if (temperatures.length < 1) return new int[]{};

        int[] ans = new int[temperatures.length];
        ans[temperatures.length - 1] = 0;
        int biggerIdx = temperatures.length - 1;
        int biggerTemperature = temperatures[temperatures.length - 1];
        for (int i = temperatures.length - 2; i >= 0; i--) {
            System.out.println(biggerIdx);
            System.out.println(biggerTemperature);
            if (temperatures[i] > biggerTemperature) {
                ans[i] = 0;
                biggerIdx = i;
                biggerTemperature = temperatures[i];
            } else {
                ans[i] = biggerIdx - i;
            }
        }
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(temperatures));
        return ans;
    }

}

