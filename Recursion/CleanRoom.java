package Recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * @leetcode: 489. Robot Room Cleaner
 */
public class CleanRoom {
    public static void main(String[] args) {}

    Robot robot;
    Set<String> cleaned;
    static int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        this.cleaned = new HashSet<>();
        clean(0, 0, 0);
    }
    private void clean(int row, int col, int dir) {
        this.robot.clean();
        for (int i = 0; i < 4; i++) {
            int[] nextDir = DIRS[(i+dir)%4];
            int nextRow = row + nextDir[0];
            int nextCol = col + nextDir[1];
            if (this.cleaned.add(nextRow + "_" + nextCol) && this.robot.move()) {
                clean(nextRow, nextCol, (i+dir)%4);
                moveBack();
            }
            this.robot.turnRight();
        }
    }
    private void moveBack() {
        this.robot.turnRight();
        this.robot.turnRight();
        this.robot.move();
        this.robot.turnRight();
        this.robot.turnRight();
    }

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();
        
        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();

        // Clean the current cell.
        public void clean();
    }
}
