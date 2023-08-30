package String;

/**
 * @leetcode: 657. Robot Return to Origin
 */
public class JudgeCircle {
    public static void main(String[] args) {}

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    x++;
                    break;
                case 'D':
                    x--;
                    break;
                case 'L':
                    y++;
                    break;
                case 'R':
                    y--;
                    break;
                default:
                    return false;
            }
        }
        return x == 0 && y == 0;
    }
}
