package Graph;

/**
 * @leetcode: 490. The Maze
 */
public class HasPathInMaze {
    public static void main(String[] args) {}

    int[][] maze;
    int[] start;
    int[] destination;
    boolean[][] visited;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        this.start = start;
        this.destination = destination;
        this.visited = new boolean[maze.length][maze[0].length];
        return check(start);
    }

    private boolean check(int[] start) {
        int r = start[0];
        int c = start[1];
        if (this.visited[r][c]) {
            return false;
        }
        if (r == this.destination[0] && c == this.destination[1]) {
            return true;
        }
        this.visited[r][c] = true;
        int[] dirs = new int[]{1, 0, -1, 0, 1};
        for (int i = 0;i < 4; i++) {
            int[] nextStop = moveTo(start, new int[]{dirs[i], dirs[i+1]});
            if (check(nextStop)) {
                return true;
            }
        }
        return false;
    }

    private int[] moveTo(int[] start, int[] dir) {
        int r = start[0];
        int c = start[1];
        while (canMove(r+dir[0], c+dir[1])) {
            r = r+dir[0];
            c = c+dir[1];
        }
        return new int[]{r,c};
    }
    private boolean canMove(int r, int c) {
        if (r >= 0 && c >= 0 && r < this.maze.length && c < this.maze[0].length && this.maze[r][c] == 0) {
            return true;
        }
        return false;
    }
}