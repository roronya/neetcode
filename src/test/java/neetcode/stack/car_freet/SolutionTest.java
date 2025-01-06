package neetcode.stack.car_freet;

import neetcode.stack.car_fleet.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    /**
     * i [0,1,2,3,4,5,6,7,8,9,10]
     * c0[x,0,x,x,1,x,x,x,x,x,g ]
     * c1[x,x,x,x,0,x,1,x,x,x,g ]
     * c2[x,x,x,x,x,x,x,0,1,x,g ]
     * c3[x,x,x,x,x,x,x,x,x,x,01]
     */
    @Test
    void example1() {
        Solution solution = new Solution();
        int target = 10;
        int[] position = new int[]{1, 4}, speed = new int[]{3, 2};
        var actual = solution.carFleet(target, position, speed);
        assertEquals(1, actual);
    }

    /**
     * i [0,1,2,3,4,5,6,7,8,9,10]
     * c0[2,1,x,x,0,x,x,3,x,x,g ]
     * c1[x,2,x,1,x,x,0,x,3,x,g ]
     * c2[x,x,2,x,x,1,x,x,0,3,g ]
     * c3[x,x,x,2,x,x,x,1,x,x,30]
     * c4[x,x,x,x,2,x,x,x,x,1,30]
     * ...
     */
    @Test
    void example2() {
        Solution solution = new Solution();
        int target = 10;
        int[] position = new int[]{4, 1, 0, 7}, speed = new int[]{2, 2, 1, 1};
        var actual = solution.carFleet(target, position, speed);
        assertEquals(3, actual);
    }

    /**
     * i [0, 1, 2, 3, 4]
     * c0[0, 1, x, x, g]
     * c1[x, x,01, x, g]
     * 0は3まで行けるが、1に追いつくのでそれ以上いけないパターンがあるはず
     */
    @Test
    void example3() {
        Solution solution = new Solution();
        int target = 4;
        int[] position = new int[]{0, 1}, speed = new int[]{3, 1};
        var actual = solution.carFleet(target, position, speed);
        assertEquals(1, actual);
    }

}