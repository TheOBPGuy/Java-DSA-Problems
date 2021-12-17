import java.util.*;

public class RobotReturnToOrigin {

    public static boolean judgeCircle(String moves) {
        // We start the robot from the origin
        int x = 0;
        int y = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                y = y+1;
            } else if (c == 'D') {
                y = y-1;
            } else if (c == 'L') {
                x = x - 1;
            } else {
                x = x + 1;
            }
        }

        if (x == 0 && y == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
