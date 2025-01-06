package neetcode.stack.car_freet;

import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        return iteration(target, position, speed);
    }

    public int iteration(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 1;
        double prevTime = (double) (target - cars[0][0]) / cars[0][1]; // いつゴールに到着するか
        for (int[] car : cars) {
            double curTime = (double) (target - car[0]) / car[1];
            if (curTime > prevTime) {
                fleets++;
                prevTime = curTime;
            }
        }
        return fleets;
    }
}
